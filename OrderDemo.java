import java.util.HashMap;
import java.util.Map;

public class OrderDemo {
    public static void main(String[] args) {
        // Initialize stock OrderItem (simulate the OrderItem data from JSON).
        Map<Integer, Integer> stockOrderItem = new HashMap<>();
        stockOrderItem.put(1, 120); // Amoxicillin
        stockOrderItem.put(2, 50);  // Azithromycin
        stockOrderItem.put(4, 300); // Paracetamol
        stockOrderItem.put(7, 80);  // Moisturizer

        // Create a standard order.
        Order standardOrder = new StandardOrder("STD-001");
        standardOrder.addItem(new OrderItem(1, 2));   // Amoxicillin: quantity 2.
        standardOrder.addItem(new OrderItem(4, 5));   // Paracetamol: quantity 5.

        // Create an urgent order.
        Order urgentOrder = new UrgentOrder("URG-001");
        urgentOrder.addItem(new OrderItem(2, 60));    // Azithromycin: quantity 60 (insufficient stock).
        urgentOrder.addItem(new OrderItem(7, 3));     // Moisturizer: quantity 3.

        // Process the orders.
        OrderService orderService = new OrderService();
        orderService.placeOrder(standardOrder, stockOrderItem);
        orderService.placeOrder(urgentOrder, stockOrderItem);
    }
}