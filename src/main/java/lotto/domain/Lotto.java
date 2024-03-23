package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers=numbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningLotto){
        return (int) numbers.stream().filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}