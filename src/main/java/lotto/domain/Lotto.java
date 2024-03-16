package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = numbers.stream()
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList());
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요");
        }
    }

    // TODO: 추가 기능 구현
    public int matchLotto(Lotto lotto) {

        int count = 0;

        for (int number : numbers) {
            if (lotto.contains(number)) {
                count++;
            }
        }

        return count;
    }


    public boolean contains(int number) {
        return numbers.contains(number);
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
