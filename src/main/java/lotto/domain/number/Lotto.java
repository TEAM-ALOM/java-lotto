package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSix(numbers);
        validateDuplicatedNumber(numbers);
    }
    private void validateSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 원소의 개수가 6개가 아닙니다.");
        }
    }
    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if(numbersSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 원소가 있습니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
// TODO: 추가 기능 구현
}
}
