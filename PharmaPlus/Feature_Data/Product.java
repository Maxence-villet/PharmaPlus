package PharmaPlus.Feature_Data;

import java.io.Serializable;

public class Product implements Serializable, Stockable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double price;
    private int stockQuantity;
    private String description;
    private String category;

    public Product(int id, String name, double price, int stockQuantity,
                   String description, String category) {
        if (!isValidPrice(price) || !isValidQuantity(stockQuantity)) {
            throw new IllegalArgumentException("❌ Price or quantity invalid");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.category = category;
    }

    @Override
    public boolean isValidPrice(double price) {
        return price > 0;
    }

    @Override
    public boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    @Override
    public void updateStock(int quantity) {
        if (isValidQuantity(quantity)) {
            this.stockQuantity = quantity;
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return String.format("%s (ID: %d) - Price: %.2f€, Stock: %d",
                name, id, price, stockQuantity);
    }
}