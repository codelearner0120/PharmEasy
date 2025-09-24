package com.example.PharmEasy.Entity;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingFloor {
    int floorNumber;
    int totalSlots;
    List<String> entryGates;
    List<String> exitGates;
    List<ParkingSlot> parkingSlots;
    Map<String, Integer> freeSlotCount;

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public List<String> getEntryGates() {
        return entryGates;
    }

    public List<String> getExitGates() {
        return exitGates;
    }

    public Map<String, Integer> getFreeSlotCount() {
        return freeSlotCount;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void setEntryGates(List<String> entryGates) {
        this.entryGates = entryGates;
    }

    public void setExitGates(List<String> exitGates) {
        this.exitGates = exitGates;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void setFreeSlotCount(Map<String, Integer> freeSlotCount) {
        this.freeSlotCount = freeSlotCount;
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "floorNumber=" + floorNumber +
                ", totalSlots=" + totalSlots +
                ", entryGates=" + entryGates +
                ", exitGates=" + exitGates +
                ", parkingSlots=" + parkingSlots +
                ", freeSlotCount=" + freeSlotCount +
                '}';
    }
}
