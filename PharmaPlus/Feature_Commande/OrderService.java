package PharmaPlus.Feature_Commande;

import java.util.Map;

public class OrderService {

    public void placeOrder(Order order, Map<Integer, Integer> stockInventory) {
        System.out.println("Placing order: " + order.getOrderId());
        if (order.validateStock(stockInventory)) {
            System.out.println("Order " + order.getOrderId() + " accepted.");
            for (OrderItem item : order.getItems()) {
                int productId = item.getProduct().getId();
                int requestedQuantity = item.getQuantity();
                int updatedStock = stockInventory.get(productId) - requestedQuantity;
                stockInventory.put(productId, updatedStock);

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