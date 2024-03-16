package lotto;

public class UserHelp {

    public static void errorUserBuy() {
        System.out.println("[ERROR] 지불한 금액이 많거나 적습니다.");
        throw new IllegalArgumentException();
    }

    public static void errorLuckyNumber_size() {
        System.out.println("[ERROR] 로또 번호의 개수는 6개입니다.");
        throw new IllegalArgumentException();
    }

    public static void errorLuckyNumber_number() {
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        throw new IllegalArgumentException();
    }

    public static void errorPlusNumber() {
        System.out.println("[ERROR] 보너스 번호는 로또 당첨 번호에 없는 숫자여야 합니다.");
        throw new IllegalArgumentException();
    }

}
