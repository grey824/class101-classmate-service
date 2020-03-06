package net.class101.classmate.infrastructure.restapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.classmate.config.restapi.Class101RestTemplateConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
@RequiredArgsConstructor
public class Class101RestTemplate {

    private final Class101RestTemplateConfig restTemplateConfig;

    @Bean
    public RestTemplate getClass101RestTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(restTemplateConfig.getConnectionTimeout());
        httpRequestFactory.setReadTimeout(restTemplateConfig.getReadTimeout());
        httpRequestFactory.setHttpClient(makeHttpClient());

        return new RestTemplate(httpRequestFactory);
    }

    private HttpClient makeHttpClient() {
        return HttpClientBuilder
                .create()
                .setMaxConnTotal(restTemplateConfig.getTotalConnection())
                .setMaxConnPerRoute(restTemplateConfig.getMaxConnectionPerRoute())
                .build();
    }
}