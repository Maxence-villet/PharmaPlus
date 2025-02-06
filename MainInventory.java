public class MainInventory {
    public static void main(String[] args) {
        System.out.println("=== PRODUCT ADDITION PROGRAM ===\n");

        ProductManager productManager = new ProductManager();
        Product newProduct = productManager.addNewProduct();

        if (newProduct != null) {
            System.out.println("\n=== ADDED PRODUCT SUMMARY ===");
            System.out.println("ID: " + newProduct.getId());
            System.out.println("Name: " + newProduct.getName());
            System.out.println("Category: " + newProduct.getCategory());
            System.out.println("Price: " + newProduct.getPrice() + "€");
            System.out.println("Stock quantity: " + newProduct.getStockQuantity());
            System.out.println("Description: " + newProduct.getDescription());
        }
    }
}