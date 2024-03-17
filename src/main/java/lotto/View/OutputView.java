package lotto.View;

import lotto.domain.Lottos;
import lotto.service.WinningRank;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    private static final String WINNING_DETAILS_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_DETAILS_MESSAGE_WITH_BONUS_MASSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    public static void printHowManyLottoUserPurchased(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void printWinningDetails(Map<WinningRank, Integer> winningDetails) {
        System.out.println("당첨 통계");
        System.out.println("---");
        winningDetails.entrySet().stream()
                .filter(entry->entry.getKey()!=WinningRank.LAST_PLACE)
                .forEach(entry->{
                    if (entry.getKey() == WinningRank.SECOND_PLACE){
                        printWinningDetailsWithBonus(entry);
                    }
                    printWinningDetails(entry);
                });
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }


    private static void printWinningDetails(Map.Entry<WinningRank, Integer> entry) {
        System.out.printf(WINNING_DETAILS_MESSAGE,
                entry.getKey().getMatchCount(),
                getFormattingPrice(entry.getKey().getPrize()),
                entry.getValue());
    }

    private static void printWinningDetailsWithBonus(Map.Entry<WinningRank, Integer> entry) {
        System.out.printf(WINNING_DETAILS_MESSAGE_WITH_BONUS_MASSAGE,
                entry.getKey().getMatchCount(),
                getFormattingPrice(entry.getKey().getPrize()),
                entry.getValue());
    }

    private static String getFormattingPrice(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(prize);
    }
}
