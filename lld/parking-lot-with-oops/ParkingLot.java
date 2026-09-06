package week11.demo_parking_app;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class ParkingLot {

    private List<ParkingSpot> parkingSpots;
    private ParkingFeeStrategy feeStrategy;


    public ParkingLot(List<ParkingSpot> parkingSpots, ParkingFeeStrategy feeStrategy) {
        this.parkingSpots = parkingSpots;
        this.feeStrategy = feeStrategy;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingFeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public void setFeeStrategy(ParkingFeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        for (ParkingSpot parkingSpot:parkingSpots){
            if(parkingSpot.canFit(vehicle)) {
                parkingSpot.park(vehicle);
                System.out.println("vehicle:" + vehicle.getNumber() + " parked at the spot id " + parkingSpot.getId());
                return parkingSpot;
            }
        }
        throw new RuntimeException("No suitable parking available");
    }

    public void removeVehicle(ParkingSpot spot, Vehicle vehicle, int hours){
        spot.removeVehicle();
        double fee = feeStrategy.calculateFee(vehicle, hours);
        System.out.println("vehicle "+vehicle.getNumber()+" is removed");
        System.out.println("parking fee "+fee);
    }
}
