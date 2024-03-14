package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");

        Scanner s = new Scanner(System.in);

        int PriceAmount = s.nextInt();

        PriceAmount = PriceAmount / 1000;

        System.out.println(PriceAmount + "개를 구매했습니다.");

    }
}
