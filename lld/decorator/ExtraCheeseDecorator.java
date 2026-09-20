package design_patterns.decorator;

public class ExtraCheeseDecorator extends PizzaDecorator{


    public ExtraCheeseDecorator(Pizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription()+" with extra cheese";
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice()+ 50;
    }
}
