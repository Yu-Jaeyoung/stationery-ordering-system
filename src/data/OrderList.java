package src.data;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<Order> orders;

    public OrderList() {
        orders = new ArrayList<>();
    }

    public void addOrder(final Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "orders : " + orders;
    }
}