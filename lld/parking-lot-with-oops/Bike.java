package lld.parking_lot;

public class Bike extends Vehicle{

    public Bike(String number, VehicleType type) {
        super(number, type);
    }

    @Override
    public boolean canFit(SpotType spotType) {
        return true;
    }
}
