package design_patterns.abstract_factory;

public enum FactoryType {

    WINDOWS(new WindowsGUIFactory()),
    MAC(new MacGUIFactory());

    private GuiFactory factory;
    FactoryType(GuiFactory factory){
        this.factory=factory;
    }

    public GuiFactory getFactory() {
        return factory;
    }
}
