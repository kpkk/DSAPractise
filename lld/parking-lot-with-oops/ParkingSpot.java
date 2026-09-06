package week11.demo_parking_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


public class ParkingSpot {
    private final int id;
    private final SpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(int id, SpotType spotType) {
        this.id = id;
        this.spotType = spotType;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotType getSpotType() {
        return spotType;
    }



    public boolean isAvailable(){
        return vehicle==null;
    }

    public boolean canFit(Vehicle vehicle){
        return isAvailable() && vehicle.canFit(spotType);
    }

    public void park(Vehicle vehicle){
        if(!isAvailable()){
            throw new RuntimeException("spot is not available");
        }
        this.vehicle=vehicle;
    }

    public void removeVehicle(){
        this.vehicle=null;
    }
}
