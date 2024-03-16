package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String LOTTO_NUMBERS_MUST_BE_SIX_DIFFERENT_NUMBERS = "[ERROR] 로 번호는 서로 다른 6개의 수여야 합니다.";
    private static final String LOTTO_NUMBERS_MUST_BE_SIX_UNIQUE_NUMBERS = "[ERROR] 로또 번호는 중복된 수가 있으면 안됩니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(LOTTO_NUMBERS_MUST_BE_SIX_DIFFERENT_NUMBERS);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println(LOTTO_NUMBERS_MUST_BE_SIX_UNIQUE_NUMBERS);
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers(){
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
