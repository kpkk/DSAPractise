package week11.demo_parking_app;

import java.util.Arrays;

public class DemoApp {

    public static void main(String[] args) {
        // create parking spots

        ParkingSpot spot1 = new ParkingSpot(1, SpotType.LARGE);
        ParkingSpot spot2 = new ParkingSpot(2, SpotType.MEDIUM);
        ParkingSpot spot3 = new ParkingSpot(3, SpotType.SMALL);
        ParkingSpot spot4 = new ParkingSpot(4, SpotType.SMALL);

        // create a fee strategy
        ParkingFeeStrategy parkingFeeStrategy = new HourlyFeeStrategy();

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(spot1, spot2, spot3, spot4), parkingFeeStrategy);

        // create vehicles
        Car car = new Car("KA011234");
        Bike bike = new Bike("TB12HG3455");
        Truck truck = new Truck("GH234HHK");

        ParkingSpot truckSpot = parkingLot.parkVehicle(truck);
        ParkingSpot carSpot = parkingLot.parkVehicle(car);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike);
        parkingLot.removeVehicle(spot1, truck, 2);

    }
}
