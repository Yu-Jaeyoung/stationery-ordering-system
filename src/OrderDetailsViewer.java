package src;

import src.data.Order;
import src.data.OrderList;
import java.util.List;

public class OrderDetailsViewer {
    private OrderList orderList;

    public OrderDetailsViewer(OrderList orderList) {
        this.orderList = orderList;
    }

    public void showAllOrderDetails() {
        final List<Order> orders = orderList.getOrders();
//        if (orders.isEmpty()) {
//            System.out.println("주문 내용이 없습니다.");
//            return;
//        }
//
//        System.out.println("전체 주문 내역:");
//        for (int i = 0; i < orders.size(); i++) {
//            System.out.println("주문 " + (i + 1) + ":");
//            showOrderDetails(orders.get(i));
//        }

        if (!orders.isEmpty()) {
            System.out.println("전체 주문 내역:");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("주문 " + (i + 1) + ":");
                showOrderDetails(orders.get(i));
            }
        } else {
            System.out.println("주문 내용이 없습니다.");
        }
    }

    // TODO : toString Override 로 수정
    public void showOrderDetails(Order order) {
        System.out.println("품명: " + order.getProductName());
        System.out.println("단위: " + order.getUnit());
        System.out.println("수량: " + order.getQuantity());
        System.out.println("단가: " + order.getUnitPrice());
        System.out.println("합계: " + order.getTotal());
        System.out.println();
    }
}
