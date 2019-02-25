package com.charge.electricity.controller;

import com.charge.electricity.model.entity.ElectricityCharge;
import com.charge.electricity.service.ElectricityChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class ElectricityChargeController {

    @Autowired
    private ElectricityChargeService electricityChargeService;

    @GetMapping("/get-customer-data")
    public Set<ElectricityCharge> getCustomerData() {
        return electricityChargeService.getCustomerData();
    }

    @PostMapping("/add-customer-data")
    public String addUser(@Valid ElectricityCharge electricityCharge, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        electricityChargeService.addCustomerData(electricityCharge);
        model.addAttribute("electricityChargeSet", electricityChargeService.getCustomerData());
        return "index";
    }

}
