package solid_design_principles;

interface Printer{
    void print();
    void scan();
    void fax();
}
class MFP implements Printer{

    @Override
    public void print() {
        System.out.println("print job is successful");
    }

    @Override
    public void scan() {
        System.out.println("Scan completed");
    }

    @Override
    public void fax() {
        System.out.println("fax has been sent to the destination");
    }
}

class SFP implements Printer{

    @Override
    public void print() {
        System.out.println("print job is successful");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("scan not supported");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("fax not supported");
    }
}

interface Iprint{
    void print();
}
interface Iscan{
    void scan();
}
interface Ifax{
    void fax();
}
class BasicPrinter implements Iprint{

    @Override
    public void print() {

    }
}
class PremiumPrinter implements Iprint, Iscan, Ifax{

    @Override
    public void fax() {

    }

    @Override
    public void print() {

    }

    @Override
    public void scan() {

    }
}
public class InterfaceSegregationEg {

    public static void main(String[] args) {
        SFP sfp = new SFP();
        sfp.scan();
    }
}
