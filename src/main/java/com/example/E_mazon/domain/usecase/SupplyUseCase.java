package com.example.E_mazon.domain.usecase;


import com.example.E_mazon.domain.api.ISupplyServicePort;
import com.example.E_mazon.domain.exception.WrongQuantity;
import com.example.E_mazon.domain.models.Supply;
import com.example.E_mazon.domain.spi.IProductPersistencePort;
import com.example.E_mazon.domain.spi.ISecurityPersistencePort;
import com.example.E_mazon.domain.spi.ISupplyPersistencePort;

import java.time.LocalDateTime;

import static com.example.E_mazon.utils.Constants.MIN_QUANTITY;
import static com.example.E_mazon.utils.Constants.WRONG_QUANTITY;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;
    private final IProductPersistencePort productPersistencePort;
    private ISecurityPersistencePort securityPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort, IProductPersistencePort productPersistencePort, ISecurityPersistencePort securityPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.securityPersistencePort = securityPersistencePort;
    }


    @Override
    public void saveSupply(Supply supply, String token) {

        securityPersistencePort.setToken(token);
        // Verificar si la fecha ya está establecida
        if (supply.getDate() == null) {
            supply.setDate(LocalDateTime.now());
        }

        // Validar la cantidad si es necesario
        if (supply.getQuantity() < MIN_QUANTITY) {
            throw new WrongQuantity(WRONG_QUANTITY);
        }

        supplyPersistencePort.saveSupply(supply);
        productPersistencePort.updateProductQuantity(supply.getProductId(), supply.getQuantity());
    }
}
