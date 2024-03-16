package domain;

public class WinningResult {
    private final Lotto lotto;
    private final int bonus;
    public WinningResult(Lotto lotto, int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }
    public Ranking match(Lotto playerNumber){
        int countOfMatch = playerNumber.countMatch(lotto);//각 로또들과 당첨 로또 비교해 몇개의 숫자 맞는지 반환
        boolean bonusCheck = playerNumber.containNumber(bonus);//보너스 번호를 맞았는지 여부 boolean형태로 반환
        return Ranking.valuesOf(countOfMatch, bonusCheck);//해당 정보들 가지고 Ranking Enum의 객체와 매치시키게 됨
    }
}