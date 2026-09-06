package lld.parking_lot;

public interface PaymentStrategy {

    public double calculateCharges(Vehicle vehicle, int hours);
}
