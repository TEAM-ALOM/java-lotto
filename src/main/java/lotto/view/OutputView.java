package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void printLottoCount(int lottoCount) {
        System.out.printf(PURCHASED_COUNT_MESSAGE, lottoCount);
    }

    public static void printPublishedLotto(List<Lotto> lotto) {
        for (Lotto l: lotto)
            System.out.println(l.getNumbers().toString());
    }
}
