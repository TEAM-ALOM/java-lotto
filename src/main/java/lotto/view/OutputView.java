package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
import lotto.domain.ResultLotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchaseLotto(PurchaseLotto purchaseLotto) {
        System.out.println();
        List<Lotto> lottos = purchaseLotto.getlottos();
        System.out.printf("%d개를 구매했습니다.\n", purchaseLotto.getSize());
        for (Lotto lotto: lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printResult(Map<ResultLotto, Integer> resultLotto) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        for (ResultLotto result : ResultLotto.values()) {
            if (result != ResultLotto.MISS) {
                System.out.println(result.getMessage(resultLotto.get(result)));
            }
        }
    }

    public static void printProfit(float profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
