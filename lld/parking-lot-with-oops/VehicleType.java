package lld.parking_lot;

public enum VehicleType {

    BIKE("BIKE"),
    CAR("CAR"),
    TRUCK("TRUCK");

    String type;
    VehicleType(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }

}
