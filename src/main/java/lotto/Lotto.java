package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    // lotto 검증 -> 생성
    public Lotto(List<Integer> numbers) {
        LottoUtils.verifyLottoNumbers(numbers);
        this.numbers = numbers;
    }

    // 로또번호 getter
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    // 로또번호 출력
    public void printLotto(){
        System.out.println(
            this.numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
