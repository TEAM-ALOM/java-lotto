package lotto.view;

public class ExceptionMessage {

    // 1. 구입 금액 양수
    public static void isPositive() {
        System.out.println("[ERROR] 구입 금액은 양수여야 한다.");
    }

    // 2. 구입 금액 1000의 배수
    public static void isDivisible() {
        System.out.println("[ERROR] 구입 금액은 1000의 배수여야 한다.");
    }

    // 3. 입력 숫자 중복
    public static void isDuplicate() {
        System.out.println("[ERROR] 로또 번호는 중복되지 않아야 한다.");
    }

    //4. 입력 숫자 범위
    public static void isNotRange() {
        System.out.println("[ERROR] 로또 번호는 1-45 사이여야 한다.");
    }

    // 5. 입력 숫자 개수 6
    public static void isCountNotSix() {
        System.out.println("[ERROR] 로또 번호는 6개를 선택해야 한다.");
    }

    // 6. 보너스 숫자 중복
    public static void isNotPossibleBonus() {
        System.out.println("[ERROR] 보너스 번호는 기존의 번호와 달라야 한다.");
    }

    // 7. 숫자가 아닌 입력
    public static void isNotNumber() {
        System.out.println("[ERROR] 입력은 숫자여야 한다.");
    }
}