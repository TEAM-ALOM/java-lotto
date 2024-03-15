package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //검증 모음
    private void validate(List<Integer> numbers){
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    //로또 번호 개수 검사 (6개 아니면 error)
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("에러");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    //중복 수 검사 (중복인 수 있으면 error)
    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> numberList = new HashSet<>(numbers);
        if(numberList.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

}
