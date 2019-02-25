package com.charge.electricity.service;

import com.charge.electricity.model.entity.ElectricityCharge;

import java.util.Set;

public interface ElectricityChargeService {

    Set<ElectricityCharge> getCustomerData();

    ElectricityCharge addCustomerData(ElectricityCharge electricityCharge);

}
