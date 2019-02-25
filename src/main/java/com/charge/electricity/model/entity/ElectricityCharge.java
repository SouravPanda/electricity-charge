package com.charge.electricity.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "T_ELECTRICITY_CHARGE")
public class ElectricityCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_number")
    private Long customerNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_consumed")
    private Double unitConsumed;

    @Column(name = "bill_amount")
    private Double billAmount;

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(Double unitConsumed) {
        this.unitConsumed = unitConsumed;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricityCharge)) return false;
        ElectricityCharge that = (ElectricityCharge) o;
        return Objects.equals(getCustomerNumber(), that.getCustomerNumber()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getUnitConsumed(), that.getUnitConsumed()) &&
                Objects.equals(getBillAmount(), that.getBillAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber(), getName(), getUnitConsumed(), getBillAmount());
    }
}
