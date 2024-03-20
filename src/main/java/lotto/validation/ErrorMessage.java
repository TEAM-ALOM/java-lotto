package lotto.validation;

public enum ErrorMessage {
    MONEY_FOR_PURCHASE_NOT_NUMBER("구매금액은 숫자로 입력해주세요"),
    WINNINGNUMBERS_NOT_START_WITH_COMMA("쉼표로 시작할 수 없습니다."),
    WINNINGNUMBERS_NOT_END_WITH_COMMA("쉼표로 끝날 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
