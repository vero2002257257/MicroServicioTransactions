package com.example.E_mazon.infrastructure.jpa.adapter;

import com.example.E_mazon.domain.models.Supply;
import com.example.E_mazon.domain.spi.ISupplyPersistencePort;
import com.example.E_mazon.infrastructure.jpa.entity.SupplyEntity;
import com.example.E_mazon.infrastructure.jpa.mapper.SupplyEntityMapper;
import com.example.E_mazon.infrastructure.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(Supply supply) {
        SupplyEntity supplyEntity = supplyEntityMapper.toSupplyEntity(supply);
        supplyRepository.save(supplyEntity);

    }
}
