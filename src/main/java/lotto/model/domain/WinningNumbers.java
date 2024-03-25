package lotto.model.domain;

import java.util.List;
import lotto.validation.Validation;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        Validation.validationBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
