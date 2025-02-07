package PharmaPlus.Feature_Inventaire;

import java.util.List;
import java.util.Scanner;
import PharmaPlus.Feature_Data.Product;

public class DeleteProduct {

    public void deleteProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in); // Création du Scanner
        try {
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
        } finally {
            scanner.close(); // Fermeture du Scanner pour éviter les fuites de ressources
        }
    }
}