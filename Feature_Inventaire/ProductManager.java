package Feature_Inventaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Feature_Data.Product;

public class ProductManager {
    private static int nextId = 1;
    private Scanner scanner;
    private List<Product> products;

    public ProductManager() {
        scanner = new Scanner(System.in);
        products = new ArrayList<>();
    }

    public Product addNewProduct() {
        System.out.println("\n=== Adding New Product ===");

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        double price = getValidPrice();
        int quantity = getValidQuantity();

        try {
            Product newProduct = new Product(
                    nextId++,
                    name,
                    price,
                    quantity,
                    description,
                    category
            );
            products.add(newProduct);
            System.out.println("✅ Product successfully added: " + newProduct);
            return newProduct;
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error creating product: " + e.getMessage());
            return null;
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        Collections.sort(products, Comparator.comparing(Product::getName));

        System.out.println("\n=== List of Available Products ===");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() +
                    ", Price: " + product.getPrice() + "€" +
                    ", Quantity: " + product.getStockQuantity() +
                    ", Category: " + product.getCategory());
        }
    }

    private double getValidPrice() {
        while (true) {
            try {
                System.out.print("Price (€): ");
                double price = Double.parseDouble(scanner.nextLine());
                if (price > 0) {
                    return price;
                }
                System.out.println("❌ Price must be greater than 0");
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number");
            }
        }
    }

    private int getValidQuantity() {
        while (true) {
            try {
                System.out.print("Stock quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0) {
                    return quantity;
                }
                System.out.println("❌ Quantity must be zero or positive");
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid integer");
            }
        }
    }

    public void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String productName = scanner.nextLine();

        Product productToDelete = null;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete == null) {
            System.out.println("Product not found: " + productName);
            return;
        }

        System.out.print("Are you sure you want to delete '" + productToDelete.getName() + "'? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            products.remove(productToDelete);
            System.out.println("Product deleted: " + productToDelete.getName());
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}