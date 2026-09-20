package design_patterns.abstract_factory;


public class Application {

    private Button button;
    private CheckBox checkBox;

    public Application(GuiFactory factory){
        this.button=factory.createButton();
        this.checkBox=factory.createCheckBox();
    }

    public void display(){
        button.render();
        checkBox.render();
    }


    public static void main(String[] args) {
        GuiFactory factory = FactoryType.WINDOWS.getFactory();
        Application application = new Application(factory);
        application.display();
    }
}
