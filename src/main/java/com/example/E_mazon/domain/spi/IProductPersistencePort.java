package com.example.E_mazon.domain.spi;

public interface IProductPersistencePort {
    void updateProductQuantity(Long productId, int quantity);
}
