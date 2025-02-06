import java.util.ArrayList;
import java.util.List;

public class MainData {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Pharmacy Management Program");

    // Story 2: Adding a new product
        ProductManager productManager = new ProductManager();
        Product newProduct = productManager.addNewProduct();

        if (newProduct != null) {
        // Story 12: Save data
            PharmacyManager pharmacyManager = new PharmacyManager();
            pharmacyManager.addProduct(newProduct);

            // Display products
            System.out.println("\nProducts List:");
            for (Product product : pharmacyManager.getProducts()) {
                System.out.println(product);
            }

        // Story 13: Statistics (+Example)
            List<Sale> sales = new ArrayList<>();
            sales.add(new Sale(newProduct, 5));

            StatisticsExport statsExport = new StatisticsExport(sales);
            statsExport.exportStatistics();
        }

        System.out.println("✅ Program Completed Successfully");
    }
}