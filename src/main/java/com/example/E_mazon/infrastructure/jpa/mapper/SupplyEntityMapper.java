package com.example.E_mazon.infrastructure.jpa.mapper;
import com.example.E_mazon.domain.models.Supply;
import com.example.E_mazon.infrastructure.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {
    SupplyEntity toSupplyEntity(Supply supply);
}
