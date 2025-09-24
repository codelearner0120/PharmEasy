package com.example.PharmEasy.Entity;

import com.example.PharmEasy.constant.SlotStatus;
import com.example.PharmEasy.constant.VehicleTypes;

public class ParkingTicket {
    String parkingLotNumber; // e.g., A1, B3
    int floorNumber;
    int rowNumber;
    int columnNumber;
    VehicleTypes vehicleType;
    Long bookedAt;

    public String getParkingLotNumber() {
        return parkingLotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setParkingLotNumber(String parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Long bookedAt) {
        this.bookedAt = bookedAt;
    }
}
