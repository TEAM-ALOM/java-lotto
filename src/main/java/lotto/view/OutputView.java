package lotto.view;

import lotto.domain.number.LottoArray;
import lotto.domain.result.MatchedPlace;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String SEPARATOR_PATTERN = "###,###";

    public static void printLottoTicketNumber(int size) {
        System.out.println();
        System.out.println(size+"개를 구매했습니다.");
    }

    public static void printLotto(LottoArray lottoArray) {
        lottoArray.getLottoArray().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void printStatistics() {
        System.out.println();
        System.out.println("당첨 통계\n---");
    }

    public static void printMatchedDetails(Map<MatchedPlace, Integer> matchedDetails) {
        matchedDetails.entrySet().stream()
                .filter(entry -> entry.getKey() != MatchedPlace.ELSE)
                .forEach(entry -> {
                    if (entry.getKey() == MatchedPlace.SECOND) {
                        printResultWithBonus(entry);
                        return;
                    }
                    printResultWithoutBonus(entry);
                });

    }

    private static void printResultWithoutBonus(Map.Entry<MatchedPlace, Integer> entry) {
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                entry.getKey().getMatchedCount(),
                getFormattingPrize(entry.getKey().getPrize()),
                entry.getValue());
    }

    private static void printResultWithBonus(Map.Entry<MatchedPlace, Integer> entry) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                entry.getKey().getMatchedCount(),
                getFormattingPrize(entry.getKey().getPrize()),
                entry.getValue());
    }
    private static String getFormattingPrize(int winningPrice) {
        DecimalFormat df = new DecimalFormat(SEPARATOR_PATTERN);
        return df.format(winningPrice);
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate);

    }
}
