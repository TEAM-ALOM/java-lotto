package lotto.domain;

public class WinnigResult {
    private final Lotto lotto;
    private final int bonusball;

    public WinnigResult(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public Ranking match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto.getNumbers());
        boolean bonusCheck = playerNumber.containNum(bonusball);
        return Ranking.valueOf(countOfMatch, bonusCheck);
    }

}
