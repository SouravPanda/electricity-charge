package com.charge.electricity.data;

import com.charge.electricity.model.entity.ElectricityCharge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityChargeDao extends CrudRepository<ElectricityCharge, Long> {
}
