package com.example.PharmEasy.Controller;

import com.example.PharmEasy.Entity.ParkingSlot;
import com.example.PharmEasy.Entity.ParkingTicket;
import com.example.PharmEasy.Entity.Vehicle;
import com.example.PharmEasy.constant.VehicleTypes;
import com.example.PharmEasy.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/available-slots")
    public List<ParkingSlot> getAllParkingSlots() {
        return parkingService.getAllParkingSlots();
    }

    @PostMapping("/available-slots-by-vehicle-type")
    public List<ParkingSlot> availbleParkingSlotByVehicleType(@RequestBody String vehicleType) {
        return parkingService.availbleParkingSlotByVehicleType(VehicleTypes.valueOf(vehicleType));
    }

    @GetMapping("/book-parking-slot")
    public ParkingTicket bookParkingSlot(@RequestBody Vehicle vehicle) {
        return parkingService.bookParkingSlot(vehicle.getVehicleNumber(), vehicle.getVehicleType().toString());
    }

    @PostMapping("/free-parking-slot")
    public List<ParkingSlot> freeParkingSlot(@RequestBody ParkingTicket parkingTicket){
        return parkingService.freeParkingSlot(parkingTicket);

    }

    @PostMapping("/generate-charge-amount")
    public double generateChargeAmount(@RequestBody ParkingTicket parkingTicket){
        return parkingService.generateChargeAmount(parkingTicket);
    }




}
