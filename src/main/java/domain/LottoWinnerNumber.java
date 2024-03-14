package domain;

import java.util.List;

public class LottoWinnerNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoWinnerNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
