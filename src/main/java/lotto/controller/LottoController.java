package lotto.controller;

import lotto.domain.LottoGenerator;
import org.kokodak.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    public void lottoStart(){
        int buyMoney;
        int bonusNumber;
        List<Integer> winLottoList;
        List<List<Integer>> lottoNumberList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력");
        buyMoney = sc.nextInt();

        LottoGenerator lottoGenerator = new LottoGenerator(buyMoney); //로또 생성기

        lottoNumberList.add(Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoNumberList.add(Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoNumberList.add(Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoNumberList.add(Arrays.asList(1, 8, 11, 31, 41, 42));
        lottoNumberList.add(Arrays.asList(13, 14, 16, 38, 42, 45));
        lottoNumberList.add(Arrays.asList(7, 11, 30, 40, 42, 43));
        lottoNumberList.add(Arrays.asList(2, 13, 22, 32, 38, 45));
        lottoNumberList.add(Arrays.asList(1, 3, 5, 14, 22, 45));

        System.out.printf("%d개를 구매했습니다.\n",lottoGenerator.lottoQuantity);
//        for (int i=0; i<lottoGenerator.lottoQuantity; i++){
//            lottoNumberList.add(lottoGenerator.generateLottos());
//        }
        System.out.println(lottoNumberList);

        System.out.println("당첨 번호를 입력해 주세요.");
        winLottoList =Arrays.stream(sc.next().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = sc.nextInt();

        // 결과 카운터
        int threeMatches = 0;
        int fourMatches = 0;
        int fiveMatches = 0;
        int fivePlusBonusMatches = 0;
        int sixMatches = 0;

        for (List<Integer> lottoNumbers : lottoNumberList) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int num : lottoNumbers) {
                if (winLottoList.contains(num)) {
                    matchCount++;
                } else if (num == bonusNumber) {
                    bonusMatch = true;
                }
            }

            // 결과 업데이트
            if (matchCount == 3) {
                threeMatches++;
            } else if (matchCount == 4) {
                fourMatches++;
            } else if (matchCount == 5) {
                if (bonusMatch) {
                    fivePlusBonusMatches++;
                } else {
                    fiveMatches++;
                }
            } else if (matchCount == 6) {
                sixMatches++;
            }
        }
        float profit;

        // 결과 출력
        System.out.println("3개 일치 (5,000원) - " + threeMatches + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatches + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatches + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fivePlusBonusMatches + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatches + "개");
        profit = (float) (threeMatches * 5000 + fourMatches * 50000 + fiveMatches * 1500000 + fivePlusBonusMatches * 30000000 + sixMatches * 2000000000) /buyMoney*100;
        System.out.println("총 수익률은 " + profit + "%입니다.");




    }
}
