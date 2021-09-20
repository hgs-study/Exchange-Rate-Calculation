package com.exchangeratecalculation.business.exchange.api;

import com.exchangeratecalculation.business.exchange.util.ExchangeUtil;
import com.exchangeratecalculation.common.util.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeUtil exchangeUtil;

    @GetMapping("/exchanges/{currency}")
    public String getExchange(@PathVariable String currency){
        return exchangeUtil.getExchange();
    }
}
