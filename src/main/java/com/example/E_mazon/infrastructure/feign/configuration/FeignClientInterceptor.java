package com.example.E_mazon.infrastructure.feign.configuration;


import com.example.E_mazon.infrastructure.security.SecurityAdapter;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.E_mazon.utils.Constants.AUTH_TOKEN;

@Component
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {

    private final SecurityAdapter securityAdapter;

    @Override
    public void apply(RequestTemplate template) {
        String token = securityAdapter.getToken();

        if (token != null && !token.isEmpty()) {
            template.header(AUTH_TOKEN, token);
        }
    }
}
