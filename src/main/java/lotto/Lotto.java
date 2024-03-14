package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 올바르지 않습니다.");
        }
        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
        }
    }
    private void validateNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number > 45 || number < 1)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private void validateBonusNumber(int bonusNumber){
        if(bonusNumber > 45 || bonusNumber < 1)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    public void addBonusNumber(int num){
        validateBonusNumber(num);
        numbers.add(num);
        Collections.sort(numbers);
    }
    public void printLotto(){
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
