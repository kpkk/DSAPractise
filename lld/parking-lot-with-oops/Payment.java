package lld.parking_lot;

public class Payment {

    public double fee(String paymentMode, Vehicle vehicle, int hours){

        double charges=0.0;
        if(paymentMode.equals("hourly")){
            // compute price
        }
        else if (paymentMode.equals("weekend")){
            // compute price
        }
        else if(paymentMode.equals("staggered")){
            // compute price
        }
        return charges;
    }
}
