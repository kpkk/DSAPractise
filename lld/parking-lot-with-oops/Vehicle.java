package lld.parking_lot;

public abstract class Vehicle {

    private String number;
    private VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public abstract boolean canFit(SpotType spotType);

}
