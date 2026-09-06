package week11.demo_parking_app;

public class Car extends Vehicle{

    public Car(String number){
        super(number, String.valueOf(VehicleType.CAR));
    }
    @Override
    public boolean canFit(SpotType spotType) {
        return SpotType.MEDIUM==spotType || SpotType.LARGE==spotType;
    }
}
