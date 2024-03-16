package lotto.domain;

public class WinResult {
    private final Lotto lotto;
    private final int bonus;
    public WinResult(Lotto lotto,int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }
    public Ranking match(Lotto playername){
        int matchCount = playername.countMatch(lotto);
        boolean bonusCheck = playername.containNumber(bonus);
        return Ranking.valueOf(matchCount,bonusCheck);
    }
}
