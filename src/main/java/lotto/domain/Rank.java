package lotto.domain;

import lotto.view.OutputView;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", false), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ", false), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ", false), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ", false), // 5등
    MISS(0, 0, "", false);

    private final int countMatch;
    private final int winningPrice;
    private final String message;
    private final boolean bonus;

    Rank(int countMatch, int winningPrice, String message, boolean bonus) {
        this.countMatch = countMatch;
        this.winningPrice = winningPrice;
        this.message = message;
        this.bonus = bonus;
    }

    public static Rank findRank(int countMatch, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countMatch == countMatch)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(Rank.MISS);
    }

    public void printMessage(int count) {
        if (this != MISS) {
            OutputView.printSuccessMessage(message, count);
        }
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
