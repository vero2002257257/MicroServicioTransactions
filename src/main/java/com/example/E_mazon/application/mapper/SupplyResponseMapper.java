package com.example.E_mazon.application.mapper;

import com.example.E_mazon.application.dto.response.SupplyResponse;
import com.example.E_mazon.domain.models.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyResponseMapper {
    SupplyResponse ToSupplyResponse(Supply supply);
}
