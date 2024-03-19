package lotto.validation;

public enum ErrorMessage {
    MONEY_FOR_PURCHASE_NOT_NUMBER("구매금액은 숫자로 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
