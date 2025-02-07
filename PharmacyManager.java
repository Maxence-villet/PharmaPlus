package PharmaPlus.Feature_Data;

import java.io.*;
import java.util.*;

public class PharmacyManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Product> products;
    private List<Sale> sales;
    private List<Object> users;

    public PharmacyManager() {
        products = new ArrayList<>();
        sales = new ArrayList<>();
        users = new ArrayList<>();
        loadData();
    }

    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pharmacy_data.ser"))) {
            out.writeObject(this);
            System.out.println("✅ Data saved successfully.");
        } catch (IOException e) {
            System.err.println("❌ Save error: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pharmacy_data.ser"))) {
            PharmacyManager savedData = (PharmacyManager) in.readObject();
            this.products = savedData.products;
            this.sales = savedData.sales;
            this.users = savedData.users;
            System.out.println("✅ Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous save found.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Load Error : " + e.getMessage());
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        saveData();
    }

    public List<Product> getProducts() {
        return products;
    }
}