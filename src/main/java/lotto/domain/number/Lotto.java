package lotto.domain.number;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 원소의 개수가 6개가 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
// TODO: 추가 기능 구현
}
