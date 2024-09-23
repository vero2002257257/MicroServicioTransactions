package com.example.E_mazon.infrastructure.configuration;

import com.example.E_mazon.domain.api.ISupplyServicePort;
import com.example.E_mazon.domain.spi.IProductPersistencePort;
import com.example.E_mazon.domain.spi.ISecurityPersistencePort;
import com.example.E_mazon.domain.spi.ISupplyPersistencePort;
import com.example.E_mazon.domain.usecase.SupplyUseCase;
import com.example.E_mazon.infrastructure.feign.client.ProductFeignClient;
import com.example.E_mazon.infrastructure.jpa.adapter.ProductJpaAdapter;
import com.example.E_mazon.infrastructure.jpa.adapter.SupplyJpaAdapter;
import com.example.E_mazon.infrastructure.jpa.mapper.SupplyEntityMapper;
import com.example.E_mazon.infrastructure.jpa.repository.ISupplyRepository;
import com.example.E_mazon.infrastructure.security.SecurityAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;
    private final ProductFeignClient productFeignClient;
    private final UserDetailsService userDetailsService;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }


    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductJpaAdapter(productFeignClient);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), productPersistencePort(), securityPersistencePort());
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public ISecurityPersistencePort securityPersistencePort() {
        return new SecurityAdapter();
    }
}
