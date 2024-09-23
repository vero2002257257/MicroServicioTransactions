package com.example.E_mazon.infrastructure.feign.configuration;

import com.example.E_mazon.infrastructure.security.SecurityAdapter;
import feign.Logger;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {

    private final SecurityAdapter securityAdapter;

    @Bean
    Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignClientInterceptor(securityAdapter);
    }
}
