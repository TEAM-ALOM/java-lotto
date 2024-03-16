package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(numbers);
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
