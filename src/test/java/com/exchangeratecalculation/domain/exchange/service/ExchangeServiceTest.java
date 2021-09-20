package com.exchangeratecalculation.domain.exchange.service;

import com.exchangeratecalculation.business.exchange.service.ExchangeService;
import com.exchangeratecalculation.business.exchange.util.ExchangeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExchangeServiceTest {
    @InjectMocks
    ExchangeService exchangeService;

    @Mock
    ExchangeUtil exchangeUtil;

    @DisplayName("환율 조회")
    @Test
    void getExchange(){
        final BigDecimal krwExchange = new BigDecimal(1100);
        final String currency = "KRW";

        given(exchangeUtil.getExchange("USD"+currency)).willReturn(krwExchange);

        exchangeService.getExchange(currency);

        verify(exchangeUtil).getExchange("USD"+currency);
    }
}
