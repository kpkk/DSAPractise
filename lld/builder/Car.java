package design_patterns.builder;

public class Car {

    private final String chassis;
    private final String wheels;
    private final String engine;
    private final String infotainmentSystem;
    private final boolean sunRoof;
    private final boolean powerWindows;
    private final boolean dashBoardCam;

    private Car(CarBuilder builder){
        this.chassis=builder.chassis;
        this.wheels=builder.wheels;
        this.engine=builder.engine;
        this.infotainmentSystem=builder.infotainmentSystem;
        this.sunRoof=builder.sunRoof;
        this.powerWindows=builder.powerWindows;
        this.dashBoardCam=builder.dashBoardCam;
    }

    public static class CarBuilder{
        private String chassis;
        private String wheels;
        private String engine;
        private String infotainmentSystem;
        private boolean sunRoof;
        private boolean powerWindows;
        private boolean dashBoardCam;

        public CarBuilder chassis(String chassis){
            this.chassis=chassis;
            return this;
        }

        public CarBuilder wheels(String wheels){
            this.wheels=wheels;
            return this;
        }
        public CarBuilder engine(String engine){
            this.engine=engine;
            return this;
        }
        public CarBuilder infotainmentSystem(String infotainmentSystem){
            this.infotainmentSystem=infotainmentSystem;
            return this;
        }
        public CarBuilder sunRoof(boolean sunRoof){
            this.sunRoof=sunRoof;
            return this;
        }

        public CarBuilder dashBoardCam(boolean dashBoardCam){
            this.dashBoardCam=dashBoardCam;
            return this;
        }
        public CarBuilder powerWindows(boolean powerWindows){
            this.powerWindows=powerWindows;
            return this;
        }

        public Car build(){
            if(chassis == null || engine==null || wheels==null)
                throw  new IllegalStateException("Chassis, enginer and wheels are mandatory");
            return new Car(this);
        }
    }
}
