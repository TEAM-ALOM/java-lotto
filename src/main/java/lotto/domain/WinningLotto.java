package lotto.domain;

import lotto.exception.ExceptionConst;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionConst.LOTTO_COUNT_EXCEPTION.getMessage());
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ExceptionConst.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
