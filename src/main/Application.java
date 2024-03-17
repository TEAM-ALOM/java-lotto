package lotto;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        sc.nextLine(); //왜???ㅠㅠ
        System.out.println();

        if (money % 1000 == 0){
            System.out.println( money/1000 + "개를 구매했습니다.");
            List<LottosReady> lottosready = new ArrayList<>();
            for (int i = 0; i < money/1000; i++){
                LottosReady lotto = new LottosReady();
                lottosready.add(lotto);
                lotto.printNumbers();
            }

            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersInput = sc.nextLine();
            List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = sc.nextInt();

            System.out.println();
            LottoResult lottoResult = new LottoResult(lottosready, winningNumbers, bonusNumber);
            lottoResult.printResult();
        }
        else{
            throw new IllegalArgumentException("금액은 1000원 단위여야 합니다.");
        }

    }
}
