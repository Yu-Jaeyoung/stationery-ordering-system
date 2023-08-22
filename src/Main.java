package src;

import src.data.Order;
import src.data.OrderLists;
import src.data.StationeryShop;
import src.data.admin.AdminLogin;

import static src.utils.IOUtils.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        OrderLists orderLists = new OrderLists();
        OrderManagement orderManagement = new OrderManagement(order, orderLists);

        StationeryShop stationeryShop = new StationeryShop();
        AdminLogin adminLogin = new AdminLogin();

        boolean state = true;
        boolean isLoggedIn = false;

        while (state) {

            showMenu();

            String choice = readUserInput();

            switch (choice) {
                case "1" -> orderManagement.isNewOrder();

                case "2" -> System.out.println("\n준비 중 입니다.");

                case "3" -> {
                    if (isLoggedIn) {
                        System.out.println("\n총 금액을 출력합니다.");
                        double totalPrice = orderLists.getTotalPrice();
                        System.out.println("총 금액 : " + totalPrice);
                    } else {
                        System.out.println("\n견적서를 출력합니다.");
                        System.out.print("견적서 번호를 입력해주세요 : ");
                        String orderNum = readUserInput();
                        System.out.println(orderLists.getOrders().get(Integer.parseInt(orderNum)));
                    }
                }

                case "4" -> {
                    if (!isLoggedIn) {
                        System.out.println("\n문구점 정보를 출력합니다.");
                        System.out.println(stationeryShop);
                    } else {
                        System.out.println("\n문구점 정보를 출력합니다.");
                        System.out.println("** 관리자 로그인 상태 **");
                        System.out.println(stationeryShop);

                        System.out.print("정보를 수정하시겠습니까 ? (Y/N) : ");
                        stationeryShop.changeStationeryShopInfo();
                    }
                }

                case "5" -> {
                    if (!isLoggedIn) {
                        isLoggedIn = adminLogin.login(isLoggedIn);
                    } else {
                        isLoggedIn = adminLogin.logout(isLoggedIn);
                    }
                }

                case "6" -> {
                    System.out.println("\n프로그램을 종료합니다.\n");
                    state = false;
                }

                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n======= 메뉴 =======");
        System.out.println("1. 견적서 작성");
        System.out.println("2. 견적서 수정");
        System.out.println("3. 견적서 출력");
        System.out.println("4. 문구점 정보");
        System.out.println("5. 관리자 로그인/로그아웃");
        System.out.println("6. 종료");
        System.out.println("===================\n");
        System.out.print("원하는 작업을 선택하세요 : ");
    }
}
