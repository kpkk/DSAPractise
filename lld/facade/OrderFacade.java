package design_patterns.facade;

public class OrderFacade {

    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public OrderFacade(){
        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        notificationService = new NotificationService();
    }


    public void executeOrder(String productId, String email, double amount, String address, int quantity){
        inventoryService.checkAvailability(productId, quantity);
        paymentService.pay(amount, productId);
        shippingService.createShipping(productId, address);
        notificationService.sendNotifications(email);
    }
}
