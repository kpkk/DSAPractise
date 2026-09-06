package week11.demo_parking_app;

public class HourlyFeeStrategy implements ParkingFeeStrategy{

    @Override
    public double calculateFee(Vehicle vehicle, int hours) {
        if(hours<=1)
            hours=1;
        if(vehicle.getVehicleType().equals("BIKE")){
            return hours*10;
        }
        else if(vehicle.getVehicleType().equals("CAR")){
            return hours*20;
        }
        else
            return hours*30;
    }
}
