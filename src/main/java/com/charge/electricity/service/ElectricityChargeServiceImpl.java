package com.charge.electricity.service;

import com.charge.electricity.data.ElectricityChargeDao;
import com.charge.electricity.model.entity.ElectricityCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ElectricityChargeServiceImpl implements ElectricityChargeService {

    @Autowired
    private ElectricityChargeDao electricityChargeDao;

    @Value("${billingLogic}")
    private String billingLogic;

    @Value("${gstCharge}")
    private String gstCharge;

    @Override
    public Set<ElectricityCharge> getCustomerData() {

        Set<ElectricityCharge> electricityChargeSet = new HashSet<>();
        electricityChargeDao.findAll().forEach(electricityCharge -> {
            electricityChargeSet.add(electricityCharge);
        });
        return electricityChargeSet;
    }

    @Override
    public ElectricityCharge addCustomerData(ElectricityCharge electricityCharge) {
        electricityCharge.setBillAmount(calculateBillAmount(electricityCharge.getUnitConsumed()));
        return electricityChargeDao.save(electricityCharge);
    }

    private Double calculateBillAmount(Double unitConsumed) {

        Double billAmount = 0.0;

        if (unitConsumed >= 0) {
            String[] unitsRange = billingLogic.split(",");
            if (unitsRange.length >= 0) {
                for (String range : unitsRange) {
                    String[] unitRange = range.split(":");
                    if (unitRange[0].equals("")) {
                        billAmount += unitConsumed * Double.parseDouble(unitRange[1]);
                        break;
                    } else if (unitConsumed <= Double.parseDouble(unitRange[0])) {
                        billAmount += unitConsumed * Double.parseDouble(unitRange[1]);
                        break;
                    } else {
                        billAmount += Double.parseDouble(unitRange[0]) * Double.parseDouble(unitRange[1]);
                        unitConsumed -= Double.parseDouble(unitRange[0]);
                    }
                }
            }
        }
        return billAmount + billAmount * Double.parseDouble(gstCharge);
    }
}
