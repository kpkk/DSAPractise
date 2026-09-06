package week11.demo_parking_app;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Truck extends Vehicle{

    public Truck(String number){
        super(number, String.valueOf(VehicleType.TRUCK));
    }

    @Override
    public boolean canFit(SpotType spotType) {
        return SpotType.LARGE==spotType;
    }
}
