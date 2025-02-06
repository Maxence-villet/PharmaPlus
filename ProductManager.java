import java.util.Scanner;

public class ProductManager {
    private static int nextId = 1;
    private Scanner scanner;

    public ProductManager() {
        scanner = new Scanner(System.in);
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
            System.out.println("✅ Product successfully added: " + newProduct);
            return newProduct;
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error creating product: " + e.getMessage());
            return null;
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
}