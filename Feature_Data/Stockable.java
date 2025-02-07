package PharmaPlus.Feature_Data;

public interface Stockable {
    boolean isValidPrice(double price);
    boolean isValidQuantity(int quantity);
    void updateStock(int quantity);
}