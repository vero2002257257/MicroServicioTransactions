package com.example.E_mazon.application.handler;

import com.example.E_mazon.application.dto.request.SupplyRequest;

public interface ISupplyHandler {
    void saveSupply(SupplyRequest supplyRequest, Long userId, String token);
}
