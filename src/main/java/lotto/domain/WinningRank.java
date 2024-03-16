package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
//    (일치 개수, 보너스볼 일치 여부, 상금)
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    LAST_PLACE(0, false, 0);

    private final int matchCount;
    private final boolean containsBonusNum;
    private final int prize;

    WinningRank(int matchCount, boolean containsBonusNum, int prize) {
        this.matchCount = matchCount;
        this.containsBonusNum = containsBonusNum;
        this.prize = prize;
    }

    public static WinningRank findWinningRank(int matchCount, boolean containsBonusNum) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchCount == matchCount)
                .filter(winningRank -> winningRank.containsBonusNum == containsBonusNum)
                .findFirst()
                .orElse(WinningRank.LAST_PLACE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
