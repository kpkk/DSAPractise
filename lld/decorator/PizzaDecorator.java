package design_patterns.decorator;

public abstract class PizzaDecorator implements Pizza{

    protected Pizza basePizza;

    public PizzaDecorator(Pizza basePizza){
        this.basePizza=basePizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription();
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice();
    }
}
