package PharmaPlus.Feature_Commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Order {
    protected String orderId;
    protected Date orderDate;
    protected List<OrderItem> items;

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = new Date();
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public abstract boolean validateStock(Map<Integer, Integer> stockOrderItem);

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", items=" + items +
                '}';
    }
}