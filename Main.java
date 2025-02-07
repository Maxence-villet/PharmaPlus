import Feature_Inventaire.DeleteProduct;
import Feature_Inventaire.LowStock;
import Feature_Inventaire.ProductManager;
import Feature_Inventaire.ProductSearch;
import Feature_Data.Product;
import Feature_Data.PharmacyManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeleteProduct deleteProduct = new DeleteProduct();
        List<Product> products = new ArrayList<>();
        PharmacyManager pharmacyManager = new PharmacyManager();

        products = pharmacyManager.getProducts();
        ProductManager productManager = new ProductManager(products);



        while (true) {
            System.out.println("\n=== PharmaPlus Management System ===");
            System.out.println("1. Add a new product");
            System.out.println("2. Show all products");
            System.out.println("3. Search for a product by name");
            System.out.println("4. Delete a product");
            System.out.println("5. Show products out of stock");
            System.out.println("6. Exit");
            System.out.print("Choose an option : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne après nextInt()

            switch (choice) {
                case 1:
                    // Ajouter un nouveau produit
                    Product newProduct = productManager.addNewProduct();
                    if (newProduct != null) {
                        pharmacyManager.addProduct(newProduct);
                    }
                    break;

                case 2:
                    // Afficher tous les produits
                    productManager.displayProducts();
                    break;

                case 3:
                    // Rechercher un produit par nom
                    System.out.print("Search the name of a product: ");
                    String searchName = scanner.nextLine();
                    ProductSearch.searchProductByName(products, searchName);
                    break;

                case 4:
                    // Supprimer un produit
                    deleteProduct.deleteProduct(products);
                    break;

                case 5:
                    // Afficher les produits en rupture de stock
                    LowStock.displayLowStockProducts(products);
                    break;

                case 6:
                    // Quitter le programme
                    System.out.println("Thank you for using PharmaPlus. See you soon!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose an option between 1 and 6.");
                    break;
            }
        }
    }
}