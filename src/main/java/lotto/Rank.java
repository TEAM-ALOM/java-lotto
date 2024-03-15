package lotto;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NONE(0, 0, false);




    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    Rank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }


    public static Rank findRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (bonusMatch || !rank.bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
