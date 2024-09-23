package com.example.E_mazon.domain.api;

import com.example.E_mazon.domain.models.Supply;

public interface ISupplyServicePort {
    void saveSupply(Supply supply, String token);
}
