package com.exchangeratecalculation.business.exchange.util;

import com.exchangeratecalculation.common.error.code.ErrorCode;
import com.exchangeratecalculation.common.error.exception.BusinessException;
import com.exchangeratecalculation.common.util.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ExchangeUtil {
    private final RestTemplateUtil restTemplateUtil;

    public BigDecimal getExchange(String currency){
        ResponseEntity<String> resultString;
        HttpEntity<?> entity = new HttpEntity<>("");

        try {
            resultString = restTemplateUtil.get().exchange("http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c", HttpMethod.GET, entity, String.class);
        } catch (Exception e){
            throw new BusinessException(ErrorCode.EXCHANGE_SERVER_ERROR);
        }

        JSONObject jsonObject = new JSONObject(resultString);
        JSONObject bodyObject = new JSONObject(jsonObject.getString("body"));
        JSONObject quotesObject = (JSONObject) bodyObject.get("quotes");

        return quotesObject.getBigDecimal(currency);
    }
}
