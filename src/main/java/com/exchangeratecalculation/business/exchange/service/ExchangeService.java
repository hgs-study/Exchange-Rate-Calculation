package com.exchangeratecalculation.business.exchange.service;

import com.exchangeratecalculation.business.exchange.util.ExchangeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final ExchangeUtil exchangeUtil;

    public BigDecimal getExchange(String currency){
        return exchangeUtil.getExchange("USD"+currency);
    }
}
