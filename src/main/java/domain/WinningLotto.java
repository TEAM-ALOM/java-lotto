package domain;

import lotto.Lotto;

import java.util.List;

public class WinningLotto {
    private static List<Integer> lotto = null;
    private final int bonus;

    public WinningLotto(List<Integer> lotto, int bonus) {
        // validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static List<Integer> getWinningLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}