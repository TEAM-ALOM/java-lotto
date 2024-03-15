package lotto.domain.number;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> array;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> array, String bonusNumber) {
        validate(array,bonusNumber);
        this.array = array;
        this.bonusNumber=Integer.parseInt(bonusNumber);
    }

    private void validate(List<Integer> array, String bonusNumber) {
        validateArraySize(array);
        validateInteger(bonusNumber);
        validateIntegerBetween1And45(Integer.parseInt(bonusNumber));
        validateArrayContainsBonusNumber(array,Integer.parseInt(bonusNumber));
    }
    private void validateArraySize(List<Integer> array) {
        if (array.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 원소의 개수가 6개가 아닙니다.");
        }
    }
    private void validateInteger(final String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] " + input + "이 정수가 아닙니다.");
        }
    }
    private void validateIntegerBetween1And45(final int input) {
        if (input<1||input>45) {
            throw new IllegalArgumentException("[ERROR] " + input + " 1과 45 사이의 정수가 아닙니다.");
        }
    }
    private void validateArrayContainsBonusNumber(final List<Integer> array ,final int number) {
        if (array.contains(number)) {
            throw new IllegalArgumentException("[ERROR]  보너스 숫자가 이미 당첨 번호에 있습니다.");
        }
    }

    public List<Integer> getArray() {
        return array;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
