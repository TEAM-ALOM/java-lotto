package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class MatchingLotto {
    private final Map<Rank, Integer> rankTable = new LinkedHashMap<>();

    private void MatchedLottoRepository() {
        rankTable.put(Rank.FIFTH, 0);  // 3개
        rankTable.put(Rank.FOURTH, 0); // 4개
        rankTable.put(Rank.THIRD, 0);  // 5개
        rankTable.put(Rank.SECOND, 0); // 5 + 1개
        rankTable.put(Rank.FIRST, 0);  // 6개
    }

    public static MatchingLotto newMatchedLottoRepository() {
        return new MatchingLotto();
    }

    public Map<Rank, Integer> getRankTable() {
        return rankTable;
    }

    public void addMatchedLotto(Rank rank) {
        if (rank != Rank.MISS) {
            rankTable.replace(rank, rankTable.get(rank) + 1);
        }
    }
}
