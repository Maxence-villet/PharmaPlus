package Feature_Data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Sale implements Serializable {
    private Product product;
    private int quantity;
    private LocalDateTime saleDate;
    private double totalPrice;

    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.saleDate = LocalDateTime.now();
        this.totalPrice = product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getSaleDate() { return saleDate; }
    public double getTotalPrice() { return totalPrice; }
}