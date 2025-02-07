package PharmaPlus.Feature_Inventaire;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import PharmaPlus.Feature_Data.Product;

public class ProductSearch {

    /**
     * Recherche un produit par son nom (insensible à la casse).
     * @param products La liste des produits.
     * @param productName Le nom du produit à rechercher.
     */
    public static void searchProductByName(List<Product> products, String productName) {
        // Tri de la liste des produits par nom (insensible à la casse) pour la recherche binaire
        Collections.sort(products, Comparator.comparing(p -> p.getName().toLowerCase()));

        // Recherche binaire insensible à la casse
        int index = binarySearch(products, productName.toLowerCase());

        if (index != -1) {
            Product foundProduct = products.get(index);
            System.out.println("Produit trouvé : " + foundProduct.getName() + " | Stock: " + foundProduct.getStockQuantity());
        } else {
            System.out.println("Produit \"" + productName + "\" introuvable dans l'inventaire.");
        }
    }

    /**
     * Implémente la recherche binaire sur une liste triée de produits.
     * @param products La liste triée des produits.
     * @param productName Le nom du produit à rechercher (en minuscules).
     * @return L'index du produit trouvé, ou -1 si non trouvé.
     */
    private static int binarySearch(List<Product> products, String productName) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midName = products.get(mid).getName().toLowerCase();

            if (midName.compareTo(productName) < 0) {
                low = mid + 1;
            } else if (midName.compareTo(productName) > 0) {
                high = mid - 1;
            } else {
                return mid; // Produit trouvé
            }
        }
        return -1; // Produit non trouvé
    }
}