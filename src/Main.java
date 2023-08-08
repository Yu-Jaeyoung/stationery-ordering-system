package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.data.OrderList;
import src.data.StationeryShop;

import static src.utils.IOUtils.closeReader;
import static src.utils.IOUtils.readUserInput;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OrderList orderList = new OrderList();
        OrderDetailsViewer orderDetailsViewer = new OrderDetailsViewer(orderList);
        OrderCreator orderCreator = new OrderCreator(orderList);
        StationeryShop stationeryShop = new StationeryShop();
        EstimatePrinter estimatePrinter = new EstimatePrinter(stationeryShop);

        try {
            while (true) {
                showMenu();

                System.out.print("원하는 작업을 선택하세요: ");
                String choice = readUserInput(reader);
                switch (choice) {
                    case "1":
                        orderCreator.createOrder(reader);
                        break;
                    case "2":
                        orderDetailsViewer.showAllOrderDetails();
                        break;
                    case "3":
                        System.out.println("\n문구점 정보를 출력합니다.\n");
                        stationeryShop.showInformation();
                        break;
                    case "4":
                        System.out.println("\n견적서를 출력합니다.\n");
                        estimatePrinter.printEstimate(orderList);
                        break;
                    case "5":
                        System.out.println("\n프로그램을 종료합니다.\n");
                        return;
                    default:
                        System.out.println("잘못된 선택입니다.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 입력입니다.");
        }
        closeReader(reader);
    }

    public static void showMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 주문 하기");
        System.out.println("2. 주문 내역 확인");
        System.out.println("3. 문구점 정보");
        System.out.println("4. 견적서 출력");
        System.out.println("5. 종료");
        System.out.println("================\n");
    }
}
