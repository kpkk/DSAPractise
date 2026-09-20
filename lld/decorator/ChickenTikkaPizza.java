package design_patterns.decorator;

public class ChickenTikkaPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Chicken Tikka Pizza";
    }

    @Override
    public double getPrice() {
        return 300.0;
    }
}
