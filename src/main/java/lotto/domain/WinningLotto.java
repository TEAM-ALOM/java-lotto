package lotto.domain;

import lotto.util.Validation;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumber, int bonusNumber) {
        Validation.validateLotto(winningNumber);
        Validation.validateBonus(winningNumber, bonusNumber);

        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
