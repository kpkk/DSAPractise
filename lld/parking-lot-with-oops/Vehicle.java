package week11.demo_parking_app;


public abstract class Vehicle {

    private String number;
    private String vehicleType;


    public Vehicle(String number, String vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract boolean canFit(SpotType spotType);
}
