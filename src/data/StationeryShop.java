package src.data;

public class StationeryShop {
    String name = "WiSoft Office";
    String owner = "Yu-Jaeyoung";
    String businessType = "도,소매";
    String category = "문구, 전산, 잡화";
    String phoneNumber = "010-1234-5678";
    double commission = 0.1;

    public void showInformation() {
        System.out.println("===== 문구점 정보 =====");
        System.out.println("상호명: " + name);
        System.out.println("대표명: " + owner);
        System.out.println("업태: " + businessType);
        System.out.println("종목: " + category);
        System.out.println("전화번호: " + phoneNumber);
        System.out.println("수수료: " + commission);
        System.out.println("=====================");
    }

    public double getCommission() {
        return commission;
    }
}
