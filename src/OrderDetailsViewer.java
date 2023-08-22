package src;

import src.data.Order;
import src.data.OrderList;
import java.util.List;

public class OrderDetailsViewer {
    private final OrderList orderList;

    public OrderDetailsViewer(final OrderList orderList) {
        this.orderList = orderList;
    }

    public void showAllOrderDetails() {
        final List<Order> orders = orderList.getOrders();

        if (!orders.isEmpty()) {
            System.out.println("전체 주문 내역:");
            System.out.println(orderList);
        } else {
            System.out.println("주문 내용이 없습니다.");
        }
    }
}
