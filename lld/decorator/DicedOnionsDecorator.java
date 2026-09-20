package design_patterns.decorator;

public class DicedOnionsDecorator extends PizzaDecorator{

    public DicedOnionsDecorator(Pizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription()+" with diced onions";
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice()+ 30;
    }
}
