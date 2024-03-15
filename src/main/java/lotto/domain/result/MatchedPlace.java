package lotto.domain.result;

import java.util.Arrays;

public enum MatchedPlace {
    ELSE(0,false,0),
    FIFTH(3,false , 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6,false , 2_000_000_000);
    private final int matchedCount;

    private final boolean matchedBonusNumber;
    private final int prize;

    public static MatchedPlace findPlace(int matchedCount, boolean matchedBonusNumber) {
        return Arrays.stream(values())
                .filter(place -> place.matchedCount == matchedCount)
                .filter(place -> place.matchedBonusNumber == matchedBonusNumber)
                .findFirst()
                .orElse(MatchedPlace.ELSE);
    }
    MatchedPlace(int matchedCount, boolean matchedBonusNumber, final int prize) {
        this.matchedCount = matchedCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.prize = prize;
    }
    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }
}
