package lld.parking_lot;

public enum SpotType {

    COMPACT("COMPACT"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");

    String space;

    SpotType(String space){
        this.space=space;
    }

    public String getSpace(){
        return space;
    }
}
