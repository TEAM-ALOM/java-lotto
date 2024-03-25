package lotto.model.domain;

import lotto.validation.Validation;

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
        Validation.validationProfitRatio(profitRatio);
        this.profitRatio = profitRatio;
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
