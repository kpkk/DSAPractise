package design_patterns.abstract_factory;

public class WindowsCheckBox implements CheckBox{


    @Override
    public void render() {
        System.out.println("rendering the windows checkbox");
    }
}
