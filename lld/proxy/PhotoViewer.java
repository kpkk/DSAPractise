package design_patterns.proxy;

public class PhotoViewer {

    public static void main(String[] args) {
        ImageProxy imageProxy = new ImageProxy("photo.jpeg");
        imageProxy.display();
        imageProxy.display();
    }
}
