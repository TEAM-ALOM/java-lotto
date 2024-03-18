package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        // sorted()와 distinct()를 쓰기 위해 stream()으로 변환시킴
        numbers = numbers.stream()
                // 오름차순 정렬
                .sorted()
                // 중복 제거
                .distinct()
                // 다시 List로 변환시킴
                .collect(Collectors.toList());

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요");
        }

        return numbers;
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
