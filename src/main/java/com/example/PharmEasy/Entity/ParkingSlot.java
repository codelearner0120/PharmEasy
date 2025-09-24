package com.example.PharmEasy.Entity;

import com.example.PharmEasy.constant.SlotStatus;
import com.example.PharmEasy.constant.VehicleTypes;
import lombok.*;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
public class ParkingSlot {
    String parkingLotNumber; // e.g., A1, B3
    int floorNumber;
    int rowNumber;
    int columnNumber;
    SlotStatus status;
    VehicleTypes vehicleType;

    public String getParkingLotNumber() {
        return parkingLotNumber;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
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

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "parkingLotNumber='" + parkingLotNumber + '\'' +
                ", floorNumber=" + floorNumber +
                ", rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                ", status=" + status +
                ", vehicleType=" + vehicleType +
                ", vehicleNumber" + '\'' +
                '}';
    }
}
