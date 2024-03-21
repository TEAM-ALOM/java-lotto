package lotto.domain;

import java.util.Arrays;

public enum Result {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FORTH(500000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);
    private final int price;
    private final int countCorrectNumber;
    private final boolean isBonusNumberCorrect;

    Result(int price, int countCorrectNumber, boolean isBonusNumberCorrect) {
        this.price = price;
        this.countCorrectNumber = countCorrectNumber;
        this.isBonusNumberCorrect = isBonusNumberCorrect;
    }
    //배껴 옴
    public static Result findLottoResult(int matchingCount, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.countCorrectNumber == matchingCount)
                .filter(winningRank -> winningRank.isBonusNumberCorrect == containsBonusNumber)
                .findFirst()
                .orElse(Result.NONE);
    }
    public String getPriceFormatted() {
        return String.format("%,d", price);
    }

    public int getPrice() {
        return price;
    }

    public int getCountCorrectNumber() {
        return countCorrectNumber;
    }
}
