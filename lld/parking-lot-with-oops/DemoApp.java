package lld.parking_lot;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoApp {

    public static void main(String[] args) {
        // create parking spots
        ParkingSpot spot1 = new ParkingSpot("1", SpotType.LARGE);
        ParkingSpot spot2 = new ParkingSpot("2", SpotType.MEDIUM);
        ParkingSpot spot3 = new ParkingSpot("3", SpotType.COMPACT);
        ParkingSpot spot4 = new ParkingSpot("4", SpotType.COMPACT);

        // create fee strategy
        PaymentStrategy paymentStrategy = new StraggeredPaymentStrategy();

        // instantiate parking lot
        ParkingLot parkingLot = new ParkingLot(Arrays.asList(spot1, spot2, spot3, spot4), paymentStrategy);

        // create vehicles
        Car car = new Car("KA09DFH3465", VehicleType.CAR);
        Truck truck = new Truck("KA09DFH3465", VehicleType.TRUCK);
        Bike bike = new Bike("TN67GF1426", VehicleType.BIKE);

        // park vehicles
        ParkingSpot parkingSpot = parkingLot.parkVehicle(car);
       // ParkingSpot parkingSpot1 = parkingLot.parkVehicle(truck);
        parkingLot.removeVehicle(car, parkingSpot, 2);
        //remove vehicles

    }
}
