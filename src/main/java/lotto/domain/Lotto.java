package lotto.domain;

import lotto.config.BaseException;
import lotto.config.BaseResponseStatus;

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
            throw new BaseException(BaseResponseStatus.LOTTO_SIZE_ERROR);
        }
        if(new HashSet<>(numbers).size() != 6){
            throw new BaseException(BaseResponseStatus.LOTTO_NUM_DUPLICATE);
        }
    }
    private void validateNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number > 45 || number < 1)
                throw new BaseException(BaseResponseStatus.NUMBER_RANGE_ERROR);
        }
    }
    private void validateBonusNumber(int bonusNumber){
        if(bonusNumber > 45 || bonusNumber < 1)
            throw new BaseException(BaseResponseStatus.NUMBER_RANGE_ERROR);
    }
    public int addBonusNumber(int num){
        validateBonusNumber(num);
        numbers.add(num);
        Collections.sort(numbers);
        return num;
    }
    public void printLotto(){
        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
