package lotto;

import lotto.controller.LottoController;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();


        // TODO: 프로그램 구현

    }
}









//
//package lotto;
//
//import org.kokodak.Randoms;
//import org.kokodak.Console;
//
//
//
//public class Application {
//    public static void main(String[] args) {
//        // TODO: 프로그램 구현
//
//        int[] lotto = new int[6];
//        Randoms randoms = new Randoms;
//
//        Lotto(randoms.in);
//
//        int money;
//        int bonus_number;
//
//
//
//
//        System.out.print("구입 금액을 입력하세요: ");
//
//        System.out.println("당첨 번호를 입력하세요(쉼표로 구분): ");
//
//        System.out.println("보너스 번호를 입력하세요: ");
//
//
//
//
//
//
//
//
//        for (int i = 0; i < lotto.length; i++) {
//            lotto[i] = random.nextInt(45) + 1;
//            // 중복번호 제거
//            for(int j = 0; j < i; j++) {
//                if(lotto[i] == lotto[j]) {
//                    i--;
//                    break;
//                }
//            }
//        }
//
//        // 오름차순 정렬
//        for(int i = 0; i < lotto.length; i++) {
//            for(int j = i + 1; j < lotto.length; j++) {
//                if(lotto[i] > lotto[j]) {
//                    int temp = lotto[i];
//                    lotto[i] = lotto[j];
//                    lotto[j] = temp;
//                }
//            }
//        }
//
//        // 랜덤번호 출력
//        System.out.println("* 로또번호 : " + Arrays.toString(lotto));
//
//
//    }
//}
