package lotto.domain;

import lotto.util.Constants;
import lotto.util.ExceptionMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATE;
import static lotto.util.ExceptionMessage.INVALID_WINNING_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNum(numbers);
        validateNumRange(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_SIZE.getMessage());
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size()!=6){
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
    private void validateDuplicateNum(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size()!=6){
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
    private void validateNumRange(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (number<=0 || number>45){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현
    //public void printResult
    public int countMatch(List<Integer> winningNum){
        return (int) numbers.stream()
                .filter(winningNum::contains).count();
    }
    public boolean containNum(int num){
        return numbers.contains(num);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
