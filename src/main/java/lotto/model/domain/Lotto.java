package lotto.model.domain;

import java.util.List;
import lotto.validation.Validation;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validationLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
