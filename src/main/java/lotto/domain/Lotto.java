package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        dupValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void dupValidate(List<Integer> numbers){
        HashSet<String> set = new HashSet<>();
        for(Integer e : numbers){
            set.add(String.valueOf(e));
        }
        if(set.size()!=6){
            throw new IllegalArgumentException();
        }
    }





}
