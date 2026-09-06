package week11.demo_parking_app;

public class WeekendFeeStrategy implements ParkingFeeStrategy{

    @Override
    public double calculateFee(Vehicle vehicle, int hours) {
        return 100;
    }
}
