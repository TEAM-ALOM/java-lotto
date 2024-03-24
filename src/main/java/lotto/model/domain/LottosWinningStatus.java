package lotto.model.domain;

import lotto.validation.ErrorMessage;

public class LottosWinningStatus {
    private final int matchesThree;
    private final int matchesFour;
    private final int matchesFive;
    private final int matchesFiveWithBonus;
    private final int matchesSix;
    private final double profitRatio;

    public LottosWinningStatus(int matchesThree, int matchesFour, int matchesFive, int matchesFiveWithBonus,
                               int matchesSix, double profitRatio) {
        this.matchesThree = matchesThree;
        this.matchesFour = matchesFour;
        this.matchesFive = matchesFive;
        this.matchesFiveWithBonus = matchesFiveWithBonus;
        this.matchesSix = matchesSix;
        validationProfitRatio(profitRatio);
        this.profitRatio = profitRatio;
    }

    private void validationProfitRatio(double profitRatio) {
        checkMaxProfitRatio(profitRatio);
    }

    private static void checkMaxProfitRatio(double profitRatio) {
        if (profitRatio > (double) WinningType.MATCHES_SIX.getProfitMoney() / 1000) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_STATUS_PROFIT_RATIO_OVER_MAX.getMessage());
        }
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public int getMatchesThree() {
        return matchesThree;
    }

    public int getMatchesFour() {
        return matchesFour;
    }

    public int getMatchesFive() {
        return matchesFive;
    }

    public int getMatchesFiveWithBonus() {
        return matchesFiveWithBonus;
    }

    public int getMatchesSix() {
        return matchesSix;
    }
}
