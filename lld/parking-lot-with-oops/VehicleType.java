package week11.demo_parking_app;

public enum VehicleType {
    CAR("CAR"),
    TRUCK("TRUCK"),
    BIKE("BIKE");

    String type;
    VehicleType(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }
}
