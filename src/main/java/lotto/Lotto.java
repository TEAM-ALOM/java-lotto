package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoUtils.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public void printLotto(){
        System.out.println(
            this.numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
