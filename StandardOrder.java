import java.util.Map;


public class StandardOrder extends Order {

    public StandardOrder(String orderId) {
        super(orderId);
    }

    @Override
    public boolean validateStock(Map<Integer, Integer> stockInventory) {
        System.out.println("Performing standard stock validation for order " + orderId);
        for (OrderItem item : items) {
            int productId = item.getProduct().getId(); // using composition to access product details
            int requestedQuantity = item.getQuantity();

            // Check if the product exists in stock and has sufficient quantity.
            if (!stockInventory.containsKey(productId) || stockInventory.get(productId) < requestedQuantity) {
                System.out.println("Insufficient stock for product ID " + productId + ". Requested: "
                        + requestedQuantity + ", Available: " + stockInventory.getOrDefault(productId, 0));
                return false; // Validation fails if any item has insufficient stock.
            }
        }
        return true; // Validation passes if all items have sufficient stock.
    }
}
