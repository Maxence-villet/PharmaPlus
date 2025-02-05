import java.util.Map;


public class OrderService {

    public void placeOrder(Order order, Map<Integer, Integer> stockInventory) {
        System.out.println("Placing order: " + order.getOrderId());
        if (order.validateStock(stockInventory)) {
            System.out.println("Order " + order.getOrderId() + " accepted.");
            // Update stock inventory after order is accepted.
            for (OrderItem item : order.getItems()) {
                int productId = item.getProduct().getId();
                int requestedQuantity = item.getQuantity();
                int updatedStock = stockInventory.get(productId) - requestedQuantity;
                stockInventory.put(productId, updatedStock);

                // Print an alert if the stock falls below a critical level (<5).
                if (updatedStock < 5) {
                    System.out.println("ALERT: Critical stock level for product "
                            + item.getProduct().getName() + " (ID " + productId + "). Remaining stock: " + updatedStock);
                }
            }
        } else {
            System.out.println("Order " + order.getOrderId() + " rejected: insufficient stock.");
        }
    }
}
