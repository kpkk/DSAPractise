package design_patterns.abstract_factory;

public class MacButton implements Button {


    @Override
    public void render() {
        System.out.println("rendering Mac button..");
    }
}
