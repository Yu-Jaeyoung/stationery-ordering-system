package src.data;

import static src.utils.IOUtils.readUserInput;

public class StationeryShop {
    String shopName = "WiSoft Office";
    String owner = "Yu-Jaeyoung";
    String businessType = "도,소매";
    String category = "문구,전산,잡화";
    String phoneNumber = "010-1234-5678";
    final String id = "jackyu0721";
    String password = "1234";
    double commission = 0.1;

    public void changeStationeryShopInfo() {

        String choice = readUserInput().toLowerCase();

        if (choice.equals("y")) {
            System.out.print("수정할 정보를 선택하세요. : ");
            choice = readUserInput().toLowerCase();

            switch (choice) {
                case "shopname" -> {
                    System.out.print("new shopName? : ");
                    shopName = readUserInput();
                    System.out.println("수정 완료");
                }

                case "owner" -> {
                    System.out.print("new Owner ? : ");
                    owner = readUserInput();
                    System.out.println("수정 완료");
                }

                case "businesstype" -> {
                    System.out.print("new BusinessType ? : ");
                    businessType = readUserInput();
                    System.out.println("수정 완료");
                }

                case "category" -> {
                    System.out.print("new Category ? : ");
                    category = readUserInput();
                    System.out.println("수정 완료");
                }

                case "phonenumber" -> {
                    System.out.print("new phoneNumber ? : ");
                    phoneNumber = readUserInput();
                    System.out.println("수정 완료");
                }

                case "password" -> {
                    System.out.println("new password ? : ");
                    password = readUserInput();
                    System.out.println("수정 완료");
                }

                // TODO : 잘못된 입력에 대한 예외 처리 추가 필요
                case "commission" -> {
                    System.out.println("new commission ? : ");
                    commission = Double.parseDouble(readUserInput());
                }

                default -> System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ShopName : " + shopName +
                "\nOwner : " + owner +
                "\nBusinessType :  " + businessType +
                "\nCategory :  " + category +
                "\nPhoneNumber : " + phoneNumber +
                "\nCommission : " + commission;
    }
}
