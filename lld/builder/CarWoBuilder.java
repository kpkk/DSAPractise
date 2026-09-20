package design_patterns.builder;

public class CarWoBuilder {

    // problem was- complex object, many parameters
    private String chassis;
    private String wheels;
    private String engine;
    private String infotainmentSystem;
    private boolean sunRoof;
    private boolean powerWindows;
    private boolean dashBoardCam;

    public CarWoBuilder(){

    }
    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setInfotainmentSystem(String infotainmentSystem) {
        this.infotainmentSystem = infotainmentSystem;
    }

    public void setSunRoof(boolean sunRoof) {
        this.sunRoof = sunRoof;
    }

    public void setPowerWindows(boolean powerWindows) {
        this.powerWindows = powerWindows;
    }

    public void setDashBoardCam(boolean dashBoardCam) {
        this.dashBoardCam = dashBoardCam;
    }


    public CarWoBuilder(
            String chassis,
            String engine,
            String wheels,
            String infotainmentSystem,
            boolean sunRoof,
            boolean powerWindows,
            boolean dashBoardCam

    ){
        this.chassis=chassis;
        this.engine=engine;
        this.wheels=wheels;
        this.infotainmentSystem=infotainmentSystem;
        this.sunRoof=sunRoof;
        this.powerWindows=powerWindows;
        this.dashBoardCam=dashBoardCam;
    }

    // telescoped constructors
    // base variant
    public CarWoBuilder(String chassis, String engine, String wheels){
        this.chassis=chassis;
        this.engine=engine;
        this.wheels=wheels;
    }
  // variant with sunroof
    public CarWoBuilder(String chassis, String engine, String wheels, boolean sunRoof){
        this.chassis=chassis;
        this.engine=engine;
        this.wheels=wheels;
        this.sunRoof=sunRoof;
    }

    // variant with infotainment
    public CarWoBuilder(String chassis, String engine, String wheels, String infotainmentSystem){
        this.chassis=chassis;
        this.engine=engine;
        this.wheels=wheels;
        this.infotainmentSystem=infotainmentSystem;
    }

    public static void main(String[] args) {
        // instantaite base variant
        CarWoBuilder carWoBuilder = new CarWoBuilder("Metal", "Petrol", "CEAT",
                null, false,
                false, false);

         // instantiate base variant
        CarWoBuilder carWoBuilder1 = new CarWoBuilder("Metal", "Petrol", "CEAT");

        CarWoBuilder carWoBuilder2 = new CarWoBuilder(); // null - bad state
        carWoBuilder2.setChassis("Fibre");
        carWoBuilder2.setEngine("Electric");
    }

}
