package src;

import src.data.Order;
import src.data.OrderList;
import java.io.BufferedReader;
import static src.utils.IOUtils.readUserInput;

public class OrderCreator {
    private Order order;
    private final OrderList orderList;

    public OrderCreator(OrderList orderList) {
        this.orderList = orderList;
    }


    public void createOrder(BufferedReader reader) {
        System.out.println("주문서 작성을 시작합니다.");

        String productName = null;
        String unit = null;
        int quantity = 0;
        double unitPrice = 0;

        while (true) {
            try {
                System.out.print("품명: ");
                productName = readUserInput(reader);

                System.out.print("단위: ");
                unit = readUserInput(reader);

                System.out.print("수량: ");
                quantity = Integer.parseInt(readUserInput(reader));

                System.out.print("단가: ");
                unitPrice = Double.parseDouble(readUserInput(reader));

                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }

        order = new Order(productName, unit, quantity, unitPrice);
        orderList.addOrder(order);

        System.out.println("주문서 작성이 완료되었습니다.");
        showOrderDetails();

        while (true) {
            System.out.print("주문서를 수정하시겠습니까? (Y/N): ");
            String modifyChoice = readUserInput(reader);
            if (modifyChoice.equalsIgnoreCase("Y")) {
                modifyOrder(reader);
                break;
            } else if (modifyChoice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Y 또는 N을 입력하세요.");
            }
        }
    }

    public void showOrderDetails() {
        System.out.println("주문 내역:");
        System.out.println("품명: " + order.getProductName());
        System.out.println("단위: " + order.getUnit());
        System.out.println("수량: " + order.getQuantity());
        System.out.println("단가: " + order.getUnitPrice());
        System.out.println("합계: " + order.getTotal());
    }

    public void modifyOrder(BufferedReader reader) {
        System.out.println("주문서 수정을 시작합니다.");

        System.out.print("품명 수정: ");
        String productName = readUserInput(reader);

        System.out.print("단위 수정: ");
        String unit = readUserInput(reader);

        System.out.print("수량 수정: ");
        int quantity = Integer.parseInt(readUserInput(reader));

        System.out.print("단가 수정: ");
        double unitPrice = Double.parseDouble(readUserInput(reader));

        order = new Order(productName, unit, quantity, unitPrice);

        System.out.println("주문서 수정이 완료되었습니다.");
        showOrderDetails();
    }
}
