package design_patterns.builder;
public class CarBuildClient {

    public static void main(String[] args) {
        Car build = new Car.CarBuilder()
                .chassis("metal")
                .engine("Hybrid")
                .wheels("Bridgestone")
                .infotainmentSystem("BOSS")
                .powerWindows(true)
                .sunRoof(false)
                .dashBoardCam(true).build();
    }
}
