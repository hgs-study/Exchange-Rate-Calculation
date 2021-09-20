package com.exchangeratecalculation.business.exchange.api;

import com.exchangeratecalculation.business.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/exchange")
    public ModelAndView exchangePage(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("exchange");
        mv.addObject("currency","KRW/USD"); // 기본 화폐 원화
        mv.addObject("money",exchangeService.getExchange("KRW").setScale(2, BigDecimal.ROUND_DOWN)); // 현재 환율

        return mv;
    }

    @GetMapping("/exchange/{currency}")
    public String getExchange(@PathVariable String currency){
        return exchangeService.getExchange(currency).setScale(2, BigDecimal.ROUND_DOWN).toString();
    }
}
