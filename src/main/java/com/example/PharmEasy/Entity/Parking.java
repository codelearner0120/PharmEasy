package com.example.PharmEasy.Entity;

import lombok.*;

import java.util.List;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Parking {
    List<ParkingFloor> parkingFloors;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
