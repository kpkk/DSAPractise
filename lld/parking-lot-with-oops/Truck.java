package lld.parking_lot;

public class Truck extends Vehicle {

    public Truck(String number, VehicleType type){
        super(number, type);
    }
    @Override
    public boolean canFit(SpotType spotType) {
        // truck can only fit if its a large space
        return spotType.getSpace().equals(SpotType.LARGE.space);
    }
}
