package lotto.model.domain;

import static lotto.validation.ErrorMessage.BONUS_NUMBER_IS_DUPLICATED;
import static lotto.validation.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;

import java.util.List;

public class WinningNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;


    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validationBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validationBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        checkNumberOutOfRange(bonusNumber);
        checkDuplicatedBonusNumber(winningLotto, bonusNumber);
    }

    private void checkDuplicatedBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private void checkNumberOutOfRange(int bonusNumber) {
        if (isNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isNumberOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
