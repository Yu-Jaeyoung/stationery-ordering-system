package src;

import src.data.Order;
import src.data.OrderList;
import src.data.StationeryShop;

public class EstimatePrinter {
    private final StationeryShop stationeryShop;

    public EstimatePrinter(StationeryShop stationeryShop) {
        this.stationeryShop = stationeryShop;
    }

    public void printEstimate(OrderList orderList) {
        double totalEstimate = 0.0;

        for (Order order : orderList.getOrders()) {
            double orderTotal = order.getTotal();
            double orderTotalWithCommission = orderTotal + (orderTotal * stationeryShop.getCommission());
            totalEstimate += orderTotalWithCommission;
        }

        System.out.println("견적서를 출력합니다.");
        System.out.println("총 견적 금액: " + totalEstimate);
    }
}