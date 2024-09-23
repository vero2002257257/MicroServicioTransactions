package com.example.E_mazon.infrastructure.jpa.adapter;

import com.example.E_mazon.application.dto.request.StockUpdateRequest;
import com.example.E_mazon.domain.spi.IProductPersistencePort;
import com.example.E_mazon.infrastructure.feign.client.ProductFeignClient;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductJpaAdapter implements IProductPersistencePort {

    private final ProductFeignClient productFeignClient;


    @Override
    public void updateProductQuantity(Long productId, int quantity) {
        StockUpdateRequest stockUpdateRequest = StockUpdateRequest.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
        productFeignClient.updateArticleQuantity(stockUpdateRequest);

    }
}
