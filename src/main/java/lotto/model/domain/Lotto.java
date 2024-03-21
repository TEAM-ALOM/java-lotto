package lotto.model.domain;

import static lotto.validation.ErrorMessage.LOTTO_HAS_DUPLICATED_NUMBER;
import static lotto.validation.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTO_SIZE_NOT_SIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeOnlySix(numbers);
        checkNumberOutOfRange(numbers);
        checkDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현

    private void checkSizeOnlySix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_NOT_SIX.getMessage());
        }
    }

    private void checkNumberOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isNumberOutOfRange(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersNotDupl = new HashSet<>();
        for (Integer number : numbers) {
            checkAndAddNumber(numbersNotDupl, number);
        }
    }

    private void checkAndAddNumber(Set<Integer> numbersNotDupl, Integer number) {
        if (numbersNotDupl.contains(number)) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATED_NUMBER.getMessage());
        }
        numbersNotDupl.add(number);
    }

    private boolean isNumberOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
