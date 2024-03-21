package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidRangeLottoNumberException;
import lotto.exception.InvalidSizeLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE=1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    // 생성자 메서드로 주어진 리스트를 사용하여 Lotto 객체를 생성
    // validate 메서드를 호출하여 번호의 유효성 확인
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers); // 정렬하고 저장
        this.numbers = numbers;
    }


    // 입력 번호 유효성 검사
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {// 번호의 개수가 LOTTO_SIZE가 아니면
            throw new InvalidSizeLottoNumberException();
        }
    }

    private void validateRange(List<Integer> numbers){
        numbers.forEach(this::validateRange);
        // 람다 표현식을 사용하여 리스트 내의 각 요소에 대해 메서드를 호출하는 방식
        // this는 현재 객체, validateRange는 Lotto 클래스 내의 메서드를 가리킴
    }

    // 단일 번호의 범위를 검증하는 메서드
    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new InvalidRangeLottoNumberException();
        }
    }

    // 번호의 중복 여부를 검증하는 메서드
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

