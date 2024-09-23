package com.example.E_mazon.application.handler;

import com.example.E_mazon.application.dto.request.SupplyRequest;
import com.example.E_mazon.application.mapper.SupplyRequestMapper;
import com.example.E_mazon.domain.api.ISupplyServicePort;
import com.example.E_mazon.domain.models.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor

public class SupplyHandler implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void saveSupply(SupplyRequest supplyRequest, Long userId, String token) {
        Supply supply = supplyRequestMapper.ToSupply(supplyRequest);
        supply.setId(userId);

        supply.setDate(LocalDateTime.now());
        supplyServicePort.saveSupply(supply, token);
    }
}
