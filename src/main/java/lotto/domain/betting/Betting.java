package lotto.domain.betting;

public class Betting {
    private static final String NOT_A_NUMBER = "[ERROR] 정수가 아닙니다.";
    private static final String LESS_THAN_0 = "[ERROR] 금액이 0보다 작습니다";

    private final int amount;
    public Betting(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String input) {
        validateInteger(input);
        validateBiggerThan0(Integer.parseInt(input));
    }
    private void validateInteger(final String input) {
        if (!(input.matches("[+-]?\\d*(\\.\\d+)?"))) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }
    }
    private void validateBiggerThan0(final int amount) {
        if (amount<=0) {
            throw new IllegalArgumentException(LESS_THAN_0);
        }
    }

    public int getAmount() {
        return amount;
    }


}
