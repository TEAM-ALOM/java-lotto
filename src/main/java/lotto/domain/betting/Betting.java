package lotto.domain.betting;

public class Betting {
    private static final int LOTTO_PRICE = 1_000;
    private final int amount;
    private final int ticketNumber;
    public Betting(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
        this.ticketNumber = Integer.parseInt(amount) / LOTTO_PRICE;
    }

    private void validate(final String input) {
        validateInteger(input);
        validateDivisibleBy1000(input);
    }

    private void validateInteger(final String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] " + input + "이 정수가 아닙니다.");
        }
    }

    private void validateDivisibleBy1000(final String input) {
        if ((Integer.parseInt(input) % LOTTO_PRICE) !=0) {
            throw new IllegalArgumentException("[ERROR] " + input + "이 1,000으로 나누어 떨어지지 않습니다.");
        }
    }
    public int getAmount() {
        return amount;
    }
    public int getTicketNumber() {
        return ticketNumber;
    }

}
