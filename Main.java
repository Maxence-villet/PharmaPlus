import Feature_Data.PharmacyManager;
import Feature_Inventaire.ProductManager;
import Feature_Data.Product;

public class Main {
    public static void main(String[] args) {
        PharmacyManager pharmacyManager = new PharmacyManager();
        ProductManager productManager = new ProductManager();

        // Exemple d'utilisation de pharmacyManager
        pharmacyManager.addProduct(new Product(1, "Amoxicilline", 5.99, 120, "Antibiotique", "Médicaments"));
        pharmacyManager.addProduct(new Product(2, "Paracétamol", 1.99, 300, "Antalgique", "Médicaments"));

        // Afficher les produits (dans pharmacymanager)
        System.out.println("Products in PharmacyManager :");
        for (Product product : pharmacyManager.getProducts()) {
            System.out.println(product);
        }

        // Exemple d'utilisation productManager
        productManager.addNewProduct();
        productManager.displayProducts();
        productManager.deleteProduct();
    }
}