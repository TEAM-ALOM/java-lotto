package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;

    public LottoResult() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank.getMatchCount() + "개 일치" + (rank.isBonusMatch() ? ", 보너스 볼 일치" : "") + " - " + results.get(rank) + "개");
            }
        }
    }

    public double calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
