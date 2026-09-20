package design_patterns.abstract_factory;

public class WindowsGUIFactory implements GuiFactory{


    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
