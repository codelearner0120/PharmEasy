package com.example.PharmEasy.Entity;

import lombok.*;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
public class ParkingCharge {
    String vehicleType;
    String chargeCriteria;
    double chargePerUnit;

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setChargeCriteria(String chargeCriteria) {
        this.chargeCriteria = chargeCriteria;
    }

    public void setChargePerUnit(double chargePerUnit) {
        this.chargePerUnit = chargePerUnit;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getChargeCriteria() {
        return chargeCriteria;
    }

    public double getChargePerUnit() {
        return chargePerUnit;
    }

    @Override
    public String toString() {
        return "ParkingCharge{" +
                "vehicleType='" + vehicleType + '\'' +
                ", chargeCriteria='" + chargeCriteria + '\'' +
                ", chargePerUnit=" + chargePerUnit +
                '}';
    }
}
