package lld.parking_lot;

public class Car extends Vehicle {

    public Car(String number, VehicleType type) {
        super(number, type);
    }

    @Override
    public boolean canFit(SpotType spotType) {
        return spotType.getSpace().equals(SpotType.LARGE.space) ||spotType.getSpace().equals(SpotType.MEDIUM.space);
    }
}
