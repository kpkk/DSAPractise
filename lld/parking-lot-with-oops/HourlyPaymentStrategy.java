package lld.parking_lot;

public class HourlyPaymentStrategy implements PaymentStrategy{


    @Override
    public double calculateCharges(Vehicle vehicle, int hours) {

        if(hours<=1)
            hours=1;
        if(vehicle.getType().equals(VehicleType.BIKE))
            return hours*10;
        else if (vehicle.getType().equals(VehicleType.CAR))
            return hours*20;
        else
            return hours*30;
    }
}
