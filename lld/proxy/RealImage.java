package design_patterns.proxy;

public class RealImage implements Image{

    private String filename;
    public RealImage(String filename){
        this.filename=filename;
        loadFromDisk(filename); // heavy operation
    }

    public void loadFromDisk(String filename){
        System.out.println("image "+filename+" is loading from disk");
    }

    @Override
    public void display() {
        System.out.println("displaying the file "+filename);
    }
}
