package design_patterns.abstract_factory;

public class WindowsButton implements Button{

    @Override
    public void render() {
        System.out.println("rendering the windows button");
    }
}
