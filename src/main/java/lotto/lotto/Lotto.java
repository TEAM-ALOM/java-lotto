package lotto.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;

    }
    private void validateRange(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }
    private void validateDuplicate(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(numbers);
        //집합에서는 중복을 허용하지 않음. 이게 낫나 2중 반복이 낫나.
        if(set.size()!=6){
            throw new IllegalArgumentException();
        }
    }
    public int hasNumber(Integer number){
        if(numbers.contains(number)==true)
        return 1;
        else
            return 0;
    }
    public boolean isSameBounusNumber(Integer bonus){
        return numbers.contains(bonus);
    }



    // TODO: 추가 기능 구현
}
