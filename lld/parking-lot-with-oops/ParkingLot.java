package lld.parking_lot;

import java.util.List;

public class ParkingLot {

    private List<ParkingSpot> parkingSpots;
    private PaymentStrategy paymentStrategy;

    public ParkingLot(List<ParkingSpot> parkingSpots, PaymentStrategy paymentStrategy) {
        this.parkingSpots = parkingSpots;
        this.paymentStrategy = paymentStrategy;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        for (ParkingSpot spot: parkingSpots){
            if(spot.canFit(vehicle)){
                spot.park(vehicle);
                System.out.println("vehicle "+vehicle.getType().type +" parked in spot "+spot.getSpotId());

                // send a notification about parking
                return spot;
            }
        }
        throw new RuntimeException("No suitable parking spot found.");
    }

    public void removeVehicle(Vehicle vehicle, ParkingSpot spot, int hours){
        spot.remove();
        // compute the charges
        double amount = paymentStrategy.calculateCharges(vehicle, hours);
        System.out.println("vehicle has been removed from spotId"+ spot.getSpotId());
        System.out.println("Charges imposed were "+ amount);

        // send a notification here
    }

}
