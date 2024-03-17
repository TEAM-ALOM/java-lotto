package lotto;

import java.util.List;

public class LottoResult {
    private final List<LottosReady> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int lottoPrice = 1000; // 로또 1장의 가격

    public LottoResult(List<LottosReady> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void printResult() {
        int[] counts = new int[7]; // 인덱스 0~6까지 일치하는 번호의 개수에 따른 로또 티켓 수를 저장
        long totalPrize = 0; // 총 당첨 상금

        for (LottosReady lotto : lottos) {
            int matchCount = lotto.match(winningNumbers);
            if (matchCount == 5 && lotto.contains(bonusNumber)) {
                counts[6]++;
                totalPrize += 30000000; // 5개 일치 + 보너스 볼
            } else {
                switch (matchCount) {
                    case 3:
                        counts[3]++;
                        totalPrize += 5000;
                        break;
                    case 4:
                        counts[4]++;
                        totalPrize += 50000;
                        break;
                    case 5:
                        counts[5]++;
                        totalPrize += 1500000;
                        break;
                    case 6:
                        counts[6]++;
                        totalPrize += 2000000000;
                        break;
                }
            }
        }

        // 당첨 통계 출력
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + counts[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + counts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts[6] + "개");

        // 총 수익률 계산 및 출력
        double profitRate = ((double) totalPrize / (lottos.size() * lottoPrice)) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }
}
