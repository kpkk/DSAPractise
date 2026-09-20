package design_patterns.facade;

public class InventoryService {

    public boolean checkAvailability(String productId, int quantity){
        return true;
    }

    public int reduceQuantity(String productId, int quantity){
        return 10; //new quantity, some dummy value as 10
    }
}
