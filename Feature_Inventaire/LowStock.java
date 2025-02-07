package PharmaPlus.Feature_Inventaire;

import java.util.List;
import PharmaPlus.Feature_Data.Product;

public class LowStock {

    public static void displayLowStockProducts(List<Product> products) {
        insertionSort(products);

        System.out.println("Produits proches de la rupture de stock (< 5 unités) :");
        boolean found = false;

        for (Product product : products) {
            if (product.getStockQuantity() < 5) {
                System.out.println("- " + product.getName() + " | Stock: " + product.getStockQuantity());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aucun produit en faible quantité.");
        }
    }

    private static void insertionSort(List<Product> products) {
        int n = products.size();

        for (int i = 1; i < n; i++) {
            Product key = products.get(i);
            int j = i - 1;

            while (j >= 0 && products.get(j).getStockQuantity() > key.getStockQuantity()) {
                products.set(j + 1, products.get(j));
                j = j - 1;
            }

            products.set(j + 1, key);
        }
    }
}