package com.exchangeratecalculation.business.exchange.util;

import com.exchangeratecalculation.common.util.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeUtil {
    private final RestTemplateUtil restTemplateUtil;

    public String getExchange(){
        String exchange = "";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        exchange = restTemplateUtil.get().exchange("http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c", HttpMethod.GET,entity, String.class).toString();

        return exchange;
    }
}
