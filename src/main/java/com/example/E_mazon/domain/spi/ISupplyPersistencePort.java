package com.example.E_mazon.domain.spi;

import com.example.E_mazon.domain.models.Supply;

public interface ISupplyPersistencePort {
    void saveSupply(Supply supply);
}
