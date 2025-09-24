package com.example.PharmEasy.service;

import com.example.PharmEasy.Entity.*;
import com.example.PharmEasy.constant.SlotStatus;
import com.example.PharmEasy.constant.VehicleTypes;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    public static Parking PARKING;

    public static Map<String, ParkingCharge> activeTickets = new java.util.HashMap<>();

    //initial static data
    @PostConstruct
    public void init() {
        Parking parking = new Parking();

        List<ParkingFloor > parkingFloors = new ArrayList<>();
        ParkingFloor floor = new ParkingFloor();
        floor.setFloorNumber(1);
        floor.setEntryGates(Arrays.asList("A"));
        floor.setExitGates(Arrays.asList("B"));
        floor.setTotalSlots(40);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            ParkingSlot slot = new ParkingSlot();

            // Set basic properties
            slot.setParkingLotNumber("S" + (i + 1)); // e.g., S1, S2, ...
            slot.setFloorNumber(1); // You can customize this
            slot.setRowNumber(i / 5); // 4 rows (0–3)
            slot.setColumnNumber(i % 5); // 5 columns (0–4)
            slot.setStatus(SlotStatus.FREE);
            if(i%2==0)
                slot.setVehicleType(VehicleTypes.TWO_WHEELER);
            else
                slot.setVehicleType(VehicleTypes.TWO_WHEELER); // Default type

            parkingSlots.add(slot);
        }
        floor.setParkingSlots(parkingSlots);
        Map<String,Integer> freeSlotCount = Map.of(VehicleTypes.FOUR_WHEELER.toString(), 20, VehicleTypes.TWO_WHEELER.toString(),20);
        floor.setFreeSlotCount(freeSlotCount);
        parkingFloors.add(floor);
        parking.setParkingFloors(parkingFloors);


        ParkingCharge twoWheelerCharge = new ParkingCharge();
        twoWheelerCharge.setVehicleType(VehicleTypes.TWO_WHEELER.toString());
        twoWheelerCharge.setChargeCriteria("min");
        twoWheelerCharge.setChargePerUnit(10.0);

        // FOUR_WHEELER charge
        ParkingCharge fourWheelerCharge = new ParkingCharge();
        fourWheelerCharge.setVehicleType(VehicleTypes.FOUR_WHEELER.toString());
        fourWheelerCharge.setChargeCriteria("hourly");
        fourWheelerCharge.setChargePerUnit(20.0);

        activeTickets.put(VehicleTypes.FOUR_WHEELER.toString(),fourWheelerCharge);
        activeTickets.put(VehicleTypes.TWO_WHEELER.toString(),twoWheelerCharge);




        PARKING = parking;
    }

    public List<ParkingSlot> getAllParkingSlots() {
        List<ParkingSlot> parkingSlots = PARKING.getParkingFloors().get(0).getParkingSlots();
        List<ParkingSlot> freeSlots = parkingSlots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .collect(Collectors.toList());

        return freeSlots;

    }

    public List<ParkingSlot> availbleParkingSlotByVehicleType(VehicleTypes vehicleType) {
        List<ParkingSlot> parkingSlots = PARKING.getParkingFloors().get(0).getParkingSlots();
        List<ParkingSlot> freeSlots = parkingSlots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.FREE && slot.getVehicleType() == vehicleType)
                .collect(Collectors.toList());

        return freeSlots;
    }

    public ParkingTicket bookParkingSlot(String vehicleNumber, String vehicleType) {
        VehicleTypes vType = VehicleTypes.valueOf(vehicleType);
        List<ParkingSlot> parkingSlots = PARKING.getParkingFloors().get(0).getParkingSlots();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getStatus() == SlotStatus.FREE && slot.getVehicleType() == vType) {
                slot.setStatus(SlotStatus.OCCUPIED);
                Map<String,Integer> mp = PARKING.getParkingFloors().get(0).getFreeSlotCount();
                mp.put(vehicleType, mp.get(vehicleType)-1);

                // Create and return a ParkingTicket
                ParkingTicket ticket = new ParkingTicket();
                ticket.setColumnNumber(slot.getColumnNumber());
                ticket.setFloorNumber(slot.getFloorNumber());
                ticket.setVehicleType(VehicleTypes.valueOf(vehicleType));
                ticket.setParkingLotNumber(slot.getParkingLotNumber());
                ticket.setBookedAt(System.currentTimeMillis());

                return ticket;
            }
        }
        return null; // No available slot found
    }

    public List<ParkingSlot> freeParkingSlot(ParkingTicket parkingTicket) {
        List<ParkingSlot> parkingSlots = PARKING.getParkingFloors().get(0).getParkingSlots();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getStatus() == SlotStatus.OCCUPIED && slot.getVehicleType() == parkingTicket.getVehicleType()
                    && slot.getParkingLotNumber().equals(parkingTicket.getParkingLotNumber())
                    && slot.getFloorNumber() == parkingTicket.getFloorNumber()
                    && slot.getColumnNumber() == parkingTicket.getColumnNumber()) {
                slot.setStatus(SlotStatus.FREE);
                Map<String,Integer> mp = PARKING.getParkingFloors().get(0).getFreeSlotCount();
                mp.put(parkingTicket.getVehicleType().toString(), mp.get(parkingTicket.getVehicleType().toString())+1);

                return getAllParkingSlots();
            }
        }
        return null; // No available slot found
    }


    public double generateChargeAmount(ParkingTicket parkingTicket) {
        long currentTime = System.currentTimeMillis();
        long durationInMillis = currentTime - parkingTicket.getBookedAt();
        long durationInMinutes = durationInMillis / (1000 * 60);
        long durationInHours = durationInMillis / (1000 * 60 * 60);
        ParkingCharge charge = activeTickets.get(parkingTicket.getVehicleType().toString());

        // calculate charge based on criteria
        double totalCharge = 0.0;
        if (charge.getChargeCriteria().equals("min")) {
            totalCharge = durationInMinutes * charge.getChargePerUnit();
        } else if (charge.getChargeCriteria().equals("hourly")) {
            totalCharge = durationInHours * charge.getChargePerUnit();
        }
        return totalCharge;
    }
}
