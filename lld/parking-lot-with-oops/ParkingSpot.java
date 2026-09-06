package lld.parking_lot;

public class ParkingSpot {
  // has-A
    private String spotId;

    private SpotType type;
    private Vehicle vehicle; // Association

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
    }

    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    // it tells me whether the parking slot is free or not
    public boolean isAvailable(){
        return this.vehicle==null;
    }
    public boolean canFit(Vehicle vehicle){
        return isAvailable()&& vehicle.canFit(type);
    }

    public void park(Vehicle vehicle){
        if(!isAvailable()){
            System.out.println("parking is not possible");
        }
        this.vehicle=vehicle;
    }

    public void remove(){
        System.out.println("removing the vehicle, freeing up the space");
        this.vehicle=null;
    }

}
