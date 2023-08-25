package src;

import src.data.Item;
import src.data.Order;
import src.data.OrderLists;

import java.util.List;

import static src.utils.IOUtils.readUserInput;

public class OrderManagement {
    private final Order order;
    private final OrderLists orderLists;

    public OrderManagement(Order order, OrderLists orderLists) {
        this.order = order;
        this.orderLists = orderLists;
    }

    public void isNewOrder() {
        int orderNum = addItem();
        System.out.println("견적서 번호 : " + orderNum);
    }

    public void isExistOrder(int orderNum){
        addItem(orderNum);
    }

    public int addItem() {
        boolean state = true;
        boolean modifySate = true;

        while (state) {
            try {
                System.out.print("제품명 : ");
                String productName = readUserInput();

                System.out.print("단위 : ");
                String unit = readUserInput();

                System.out.print("수량 : ");
                int quantity = Integer.parseInt(readUserInput());

                System.out.print("단가 : ");
                double unitPrice = Double.parseDouble(readUserInput());


                while (modifySate) {

                    System.out.print("내용 수정 ? (Y/N) : ");
                    // TODO : Y/N 외 입력에 대한 처리 추가 필요
                    String choice = readUserInput().toLowerCase();

                    if (choice.equals("y")) {
                        System.out.print("수정할 정보를 선택하세요. : ");
                        choice = readUserInput();
                        switch (choice) {
                            case "제품명" -> {
                                System.out.print("new 제품명? : ");
                                productName = readUserInput();
                                System.out.println("수정 완료");
                            }
                            // TODO : 단위 부분 Enum 타입으로 지정 ? ?
                            case "단위" -> {
                                System.out.print("new 단위 ? : ");
                                unit = readUserInput();
                                System.out.println("수정 완료");
                            }

                            case "수량" -> {
                                System.out.print("new 수량 ? : ");
                                quantity = Integer.parseInt(readUserInput());
                                System.out.println("수정 완료");
                            }

                            case "단가" -> {
                                System.out.println("new 단가 ? : ");
                                unitPrice = Double.parseDouble(readUserInput());
                                System.out.println("수정 완료");
                            }

                            default -> System.out.println("잘못 입력하셨습니다.");
                        }
                    } else {
                        modifySate = false;
                    }
                }

                Item item = new Item(productName, unit, quantity, unitPrice);
                order.addItem(item);

                // TODO : Y/N 외 입력에 대한 처리 추가 필요
                System.out.print("더 아이템을 추가하시겠습니까? (Y/N): ");
                String continueInput = readUserInput();
                state = continueInput.equalsIgnoreCase("y");

                if (state) {
                    modifySate = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
        return orderLists.addOrder(order);
    }

    public void addItem(int orderNum) {

        boolean state = true;
        boolean modifySate = true;

        while (state) {
            try {
                System.out.print("제품명 : ");
                String productName = readUserInput();

                System.out.print("단위 : ");
                String unit = readUserInput();

                System.out.print("수량 : ");
                int quantity = Integer.parseInt(readUserInput());

                System.out.print("단가 : ");
                double unitPrice = Double.parseDouble(readUserInput());

                while (modifySate) {

                    // TODO : Y/N 외 입력에 대한 처리 추가 필요
                    System.out.print("내용 수정 ? (Y/N) : ");
                    String choice = readUserInput().toLowerCase();
                    if (choice.equals("y")) {
                        System.out.print("수정할 정보를 선택하세요. : ");
                        choice = readUserInput();
                        switch (choice) {
                            case "제품명" -> {
                                System.out.print("new 제품명? : ");
                                productName = readUserInput();
                                System.out.println("수정 완료");
                            }

                            case "단위" -> {
                                System.out.print("new 단위 ? : ");
                                unit = readUserInput();
                                System.out.println("수정 완료");
                            }

                            case "수량" -> {
                                System.out.print("new 수량 ? : ");
                                quantity = Integer.parseInt(readUserInput());
                                System.out.println("수정 완료");
                            }

                            case "단가" -> {
                                System.out.println("new 단가 ? : ");
                                unitPrice = Double.parseDouble(readUserInput());
                                System.out.println("수정 완료");
                            }

                            default -> System.out.println("잘못 입력하셨습니다.");
                        }
                    } else {
                        modifySate = false;
                    }
                }

                Item item = new Item(productName, unit, quantity, unitPrice);
                orderLists.getOrders().get(orderNum - 1).addItem(item);

                // TODO : Y/N 외 입력에 대한 처리 추가 필요
                System.out.print("더 아이템을 추가하시겠습니까? (Y/N): ");
                String continueInput = readUserInput();

                state = continueInput.equalsIgnoreCase("y");

                if (state) {
                    modifySate = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
    }

    // TODO : 수정 기능 추가
    public void fixOrderItem(int orderNum) {

        // TODO : 취소 기능 추가 필요
        System.out.print("품목명을 입력하시오. : ");
        String productName = readUserInput();

        Order targetOrder = orderLists.getOrders().get(orderNum - 1);

        List<Item> items = targetOrder.getItems();

        Item fixedItem = null;

        // TODO : 해당하는 품목이 없는 경우에 대한 처리 추가 필요
        for (Item item : items) {
            if (item.getProductName().equals(productName)) {
                fixedItem = item;
                break;
            }
        }

        if (fixedItem != null) {

            // TODO : 취소 기능 추가 필요
            System.out.println("수정할 내용을 선택하세요.");
            System.out.println("1. 수량 ");
            System.out.println("2. 단가 ");
            System.out.print("숫자로 입력 : ");
            String choice = readUserInput();

            switch (choice) {
                case "1" -> {
                    System.out.print("수정 할 수량 : ");
                    int quantity = Integer.parseInt(readUserInput());
                    fixedItem.updateQuantity(quantity);
                }

                case "2" -> {
                    System.out.print("수정 할 단가 : ");
                    double unitPrice = Double.parseDouble(readUserInput());
                    fixedItem.updateUnitPrice(unitPrice);
                }
            }
        }
    }
}
