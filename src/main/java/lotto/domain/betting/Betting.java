package lotto.domain.betting;

public class Betting {
    private static final String NOT_A_NUMBER = "[ERROR] 정수가 아닙니다.";

    private final int amount;
    public Betting(final String amount) {
        validateInteger(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateInteger(final String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }
    }


    public int getAmount() {
        return amount;
    }


}
