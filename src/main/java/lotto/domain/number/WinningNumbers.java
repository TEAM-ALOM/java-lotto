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

    public List<Integer> getArray() {
        return array;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
