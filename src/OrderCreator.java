package src;

import src.data.Order;
import src.data.OrderList;

import static src.utils.IOUtils.readUserInput;

public class OrderCreator {
    private final OrderList orderList;

    public OrderCreator(final OrderList orderList) {
        this.orderList = orderList;
    }

    public void createOrder() {
        System.out.println("주문서 작성을 시작합니다.");

        while (true) {
            try {

                System.out.print("품명: ");
                final String productName = readUserInput();

                System.out.print("단위: ");
                final String unit = readUserInput();

                System.out.print("수량: ");
                final int quantity = Integer.parseInt(readUserInput());

                System.out.print("단가: ");
                final double unitPrice = Double.parseDouble(readUserInput());

                Order order = new Order(productName, unit, quantity, unitPrice);

                System.out.println("주문서 작성이 완료되었습니다.");
                System.out.println(order);

                orderList.addOrder(order);

                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }

//        while (true) {
//
//            System.out.print("주문서를 수정하시겠습니까? (Y/N): ");
//            String modifyChoice = readUserInput();
//
//            if (modifyChoice.equalsIgnoreCase("Y")) {
//                modifyOrder();
//
//                break;
//            } else if (modifyChoice.equalsIgnoreCase("N")) {
//                break;
//            } else {
//                System.out.println("Y 또는 N을 입력하세요.");
//            }
//        }
    }

    // TODO : 주문서 수정 부분 구체화
//    public void modifyOrder() {
//        System.out.println("주문서 수정을 시작합니다.");
//
//        System.out.print("품명 수정: ");
//        String productName = readUserInput();
//
//        System.out.print("단위 수정: ");
//        String unit = readUserInput();
//
//        System.out.print("수량 수정: ");
//        int quantity = Integer.parseInt(readUserInput());
//
//        System.out.print("단가 수정: ");
//        double unitPrice = Double.parseDouble(readUserInput());
//
//        order = new Order(productName, unit, quantity, unitPrice);
//
//        System.out.println("주문서 수정이 완료되었습니다.");
//        System.out.println(order);
//    }
}