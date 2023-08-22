package src.data.admin;

import src.data.StationeryShop;

import static src.utils.IOUtils.readUserInput;

public class AdminLogin {
    StationeryShop shop = new StationeryShop();

    public boolean login(final boolean isLoggedIn) {
        if (isLoggedIn) {
            System.out.println("이미 로그인 하셨습니다.");
        } else {
            System.out.print("\n아이디 : ");
            String enteredId = readUserInput();
            System.out.print("비밀번호 : ");
            String enteredPassword = readUserInput();

            if (enteredId.equals(shop.id) && enteredPassword.equals(shop.password)) {
                String owner = shop.getOwner();
                System.out.println("로그인 성공");
                System.out.println(owner + " 님 환영합니다.");
                return true;
            }

            System.out.println("로그인 실패");
            return false;
        }
        return false;
    }

    public boolean logout(final boolean isLoggedIn) {
        if(isLoggedIn){
            System.out.println("로 그 아 웃");
        } else {
            System.out.println("로그인 상태가 아닙니다.");
        }
        return false;
    }
}
