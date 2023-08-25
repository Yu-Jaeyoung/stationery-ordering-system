package src.data;

import java.util.ArrayList;
import java.util.List;

public class OrderLists {
    private final List<Order> orders;

    public OrderLists() {
        orders = new ArrayList<>();
    }

    public int addOrder(final Order order) {
        orders.add(order);
        return orders.size(); // return 되는 값 : 주문 번호
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getListSize() {
        return orders.size();
    }

    public double getTotalPrice() {
        double total = 0;

        for (Order order : orders) {
            total += order.getTotalPrice();
        }

        return total;
    }
}
