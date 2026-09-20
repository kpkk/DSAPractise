package design_patterns.decorator;

public class MargheritaPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getPrice() {
        return 250.0;
    }
}
