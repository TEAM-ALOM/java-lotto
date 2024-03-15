package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.SortLottoNumber.sortNumbers;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println("[ERROR] 로또 번호는 중복된 수가 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

}
