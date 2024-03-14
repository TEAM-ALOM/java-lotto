package lotto.domain.result;

import java.util.Map;

public class EarningsRate {

    public static long getEarning(Map<MatchedPlace, Integer> winningDetails) {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public static double getEarningsRate(long winningAmount, int money) {
        double lottoYield = 100 + (double) (winningAmount - money) / money * 100;
        return Math.round(lottoYield * 10) / 10.0;
    }

}
