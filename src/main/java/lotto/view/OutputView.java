package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATICS_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_DETAIL_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_BONUS_DETAIL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String COMMA_FORMAT = "###,###";

    public static void printLottoCount(int lottoCount) {
        System.out.printf(PURCHASED_COUNT_MESSAGE, lottoCount);
    }

    public static void printPublishedLotto(List<Lotto> lotto) {
        for (Lotto l: lotto)
            System.out.println(l.getNumbers().toString());
    }

    public static void printWinningResult(Map<WinningRank, Integer> winningResult, double returnRate) {
        System.out.println(WINNING_STATICS_MESSAGE);

        winningResult.forEach((rank, count) -> {
            String reword = getFormattingResult(rank.getReword());

            if (rank == WinningRank.LAST_RANK) return;
            if (rank == WinningRank.SECOND_BONUS_RANK) {
                System.out.printf(WINNING_BONUS_DETAIL_MESSAGE, rank.getMatch(), reword, count);
                return;
            }
            System.out.printf(WINNING_DETAIL_MESSAGE, rank.getMatch(), reword, count);
        });

        System.out.printf(RETURN_RATE_MESSAGE, returnRate);
    }

    public static String getFormattingResult(int result) {
        DecimalFormat df = new DecimalFormat(COMMA_FORMAT);
        return df.format(result);
    }
}
