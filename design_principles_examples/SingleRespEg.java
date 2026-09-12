package solid_design_principles;

class Invoice {
    // violating the single responsibility
    public void totalCalculations(){

    }
    public void saveToDatabase(){

    }
    public void generateReport(){
        // pdf, (.xlsk, html)
    }
    public void sendNotification(){
        // change in notification this will undergo change
    }
}
class InvoiceComputaion{
    public void totalCalc(){

    }
}

class InvoiceGenerate{
    public void generate_invoice(){

    }
}
public class SingleRespEg {
}
