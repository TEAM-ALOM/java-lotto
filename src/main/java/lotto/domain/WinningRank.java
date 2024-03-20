package lotto.domain;

import java.util.Arrays;

// 당첨 등수
public enum WinningRank {
    LAST_RANK(0, 0, false),
    FORTH_RANK(3, 5_000, false),
    THIRD_RANK(4, 50_000, false),
    SECOND_RANK(5, 1_500_000, false),
    SECOND_BONUS_RANK(5, 30000000, true),
    FIRST_RANK(6, 2_000_000_000, false);

    private final int match;
    private final int reword;
    private final boolean bonus;

    WinningRank(int match, int reword, boolean bonus) {
        this.match = match;
        this.reword = reword;
        this.bonus = bonus;
    }

    // 맞힌 번호 개수 반환
    public int getMatch() {
        return match;
    }

    // 당첨금 반환
    public int getReword() {
        return reword;
    }

    // 해당 조건 등수 반환
    public static WinningRank findWinningRank(int match, boolean bonus) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.match == match)
                .filter(winningRank -> winningRank.bonus == bonus)
                .findFirst()
                .orElse(LAST_RANK);
    }
}
