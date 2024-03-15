package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount;
        System.out.println("구입 금액을 입력해 주세요");
        purchaseAmount = Integer.parseInt(Console.readLine());
        if(purchaseAmount < 1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다");
        }



    }
}
