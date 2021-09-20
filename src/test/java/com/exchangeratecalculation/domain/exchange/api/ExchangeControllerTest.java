package com.exchangeratecalculation.domain.exchange.api;

import com.exchangeratecalculation.business.exchange.service.ExchangeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExchangeService exchangeService;

    @DisplayName("환율 조회")
    @Test
    void getExchange() throws Exception {
        final BigDecimal krwExchange = new BigDecimal(1100);
        final String currency = "KRW";

        given(exchangeService.getExchange(currency)).willReturn(krwExchange);

        mockMvc.perform(get("/exchange/{currency}",currency))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(krwExchange.toString())))
                .andDo(print());

        verify(exchangeService).getExchange(currency);
    }
}
