package design_patterns.decorator;

public class PizzaOrderApp {

    public static void main(String[] args) {
        MargheritaPizza margheritaPizza = new MargheritaPizza();
        System.out.println(margheritaPizza.getDescription());
        System.out.println(margheritaPizza.getPrice());
        System.out.println("##############################");
        ExtraCheeseDecorator extraCheeseDecorator = new ExtraCheeseDecorator(new MargheritaPizza());
        System.out.println(extraCheeseDecorator.getDescription());
        System.out.println(extraCheeseDecorator.getPrice());
        System.out.println("##############################");
        ExtraCheeseDecorator chickenPizzaWithToppings = new ExtraCheeseDecorator(new DicedOnionsDecorator(new ChickenTikkaPizza()));
        System.out.println(chickenPizzaWithToppings.getDescription());
        System.out.println(chickenPizzaWithToppings.getPrice());
    }
}
