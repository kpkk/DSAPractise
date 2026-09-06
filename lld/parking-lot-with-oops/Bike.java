package week11.demo_parking_app;


public class Bike extends Vehicle{


    public Bike(String number){
        super(number, String.valueOf(VehicleType.BIKE));
    }
    @Override
    public boolean canFit(SpotType spotType) {
        return true;
    }
}
