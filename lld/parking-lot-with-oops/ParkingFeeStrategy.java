package week11.demo_parking_app;

public interface ParkingFeeStrategy {

    public double calculateFee(Vehicle vehicle, int hours);
}
