package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalDataDao extends JpaRepository<PhysicalData, Long> {
}