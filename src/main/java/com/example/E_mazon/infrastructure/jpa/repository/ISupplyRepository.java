package com.example.E_mazon.infrastructure.jpa.repository;

import com.example.E_mazon.infrastructure.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
