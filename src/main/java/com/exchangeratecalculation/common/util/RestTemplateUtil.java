package com.exchangeratecalculation.common.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {
    public RestTemplate get(){
        HttpClient httpClient = HttpClientBuilder.create()
                                                 .setMaxConnTotal(200)
                                                 .setMaxConnPerRoute(20)
                                                 .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(3000); // 읽기시간초과, ms
        factory.setConnectTimeout(3000); // 연결시간초과, ms
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }
}
