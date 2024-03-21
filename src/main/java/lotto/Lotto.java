package lotto;
import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers; //로또 숫자들을 저장할 배열

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    } //constructor

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers()
    {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
