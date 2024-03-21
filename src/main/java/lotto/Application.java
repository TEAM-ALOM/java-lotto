package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int lotto_price = 1000;

        Scanner scanner = new Scanner(System.in);

        //System.out.println("로또 구입 금액을 입력해주세요.");
        System.out.println("Please enter the amount of lotto purchase.");
        int money = scanner.nextInt();
        if (money % 1000 != 0){
            throw new IllegalArgumentException("This is not an appropriate value. Please check the amount again.");
        }

        List<Integer> numbers = new ArrayList<>();


    }
}
