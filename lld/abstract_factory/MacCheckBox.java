package design_patterns.abstract_factory;

public class MacCheckBox implements CheckBox{

    @Override
    public void render() {
        System.out.println("rendering the mac check box");
    }
}
