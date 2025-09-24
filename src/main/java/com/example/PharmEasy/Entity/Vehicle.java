package com.example.PharmEasy.Entity;

import com.example.PharmEasy.constant.VehicleTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    String vehicleNumber;
    VehicleTypes vehicleType;

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
