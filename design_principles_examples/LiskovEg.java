package solid_design_principles;

class Bird{

    public void fly(){
        System.out.println("bird can fly");
    }

    public void eat(){
        System.out.println("bird can eat");
    }
}
class Sparrow extends Bird{
    public void fly(){
        System.out.println("bird can fly");
    }

    public void eat(){
        System.out.println("bird can eat");
    }
}
class Penguin{

    public void fly(){
        throw  new UnsupportedOperationException("penguin can't fly");
    }

    public void eat(){
        System.out.println("bird can eat");
    }
}

interface Ibird{
    void eat();
}
interface IflyBird{
    void fly();
}
class Dove implements Ibird, IflyBird{

    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }
}
class Penguine implements Ibird{

    @Override
    public void eat() {

    }
}

class Rectangle{
    private int width;
    private int height;
    void setWidth(int width){
        this.width=width;
    }
    void setHeight(int height){
        this.height=height;
    }
}

// violating the liskov principle as the child is setting one extra property which could
// break consumers

class Square extends Rectangle{
    private int width;
    private int height;
    void setWidth(int width){
        this.width=width;
        this.height=width; // silently setting one more property
    }
}

public class LiskovEg {

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        sparrow.fly();
        Penguin penguin = new Penguin();
        penguin.fly();
    }


}
