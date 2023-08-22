package src;

import src.data.Item;
import src.data.Order;
import src.data.OrderLists;

import static src.utils.IOUtils.readUserInput;

public class OrderManagement {
    private final Order order;
    private final OrderLists orderLists;

    public OrderManagement(Order order, OrderLists orderLists) {
        this.order = order;
        this.orderLists = orderLists;
    }

    public void isNewOrder() {
        System.out.println("1. 새로운 견적서 작성");
        System.out.println("2. 기존 견적서에 추가");
        System.out.print("번호 입력 : ");
        String choice = readUserInput();

        switch (choice) {
            case "1" -> {
                System.out.println("새로운 견적서 작성을 진행합니다.");

                int orderNum = addItem();

                System.out.println("견적서 번호 : " + orderNum);
            }
            // TODO : 견적서가 존재하지 않는 경우에 대한 예외 처리 필요
            case "2" -> {
                System.out.println("기존 견적서에 추가로 작성합니다.");
                System.out.print("견적서 번호를 입력하세요 : ");

                String orderNum = readUserInput();
                addItem(Integer.parseInt(orderNum));
            }
            default -> System.out.println("잘못된 선택입니다.");
        }
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
                    System.out.println("내용 수정 ? (Y/N) : ");
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
                order.addItem(item);

                System.out.print("더 아이템을 추가하시겠습니까? (y/n): ");
                String continueInput = readUserInput();
                state = continueInput.equalsIgnoreCase("y");

                if (state) {
                    modifySate = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
        return orderLists.addOrder(order) - 1;
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
                    System.out.println("내용 수정 ? (Y/N) : ");
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
                orderLists.getOrders().get(orderNum).addItem(item);

                System.out.print("더 아이템을 추가하시겠습니까? (y/n): ");
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
}
