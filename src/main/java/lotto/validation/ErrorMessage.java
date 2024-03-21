package lotto.validation;

public enum ErrorMessage {
    MONEY_FOR_PURCHASE_NOT_NUMBER("구매금액은 숫자로 입력해주세요"),

    WINNINGNUMBERS_NOT_START_WITH_COMMA("쉼표로 시작할 수 없습니다."),
    WINNINGNUMBERS_NOT_END_WITH_COMMA("쉼표로 끝날 수 없습니다."),
    WINNINGNUMBERS_NOT_DOUBLE_COMMA("쉼표 사이에 숫자를 넣어주세요"),

    LOTTO_SIZE_NOT_SIX("로또 번호 개수는 6개입니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1~45 사이의 수입니다."),
    LOTTO_HAS_DUPLICATED_NUMBER("중복된 숫자는 기입할 수 없습니다."),

    LOTTOS_COUNT_OUT_OF_RANGE_100("로또는 1회당 100개까지 구매가능합니다."),
    LOTTOS_SIZE_NOT_MATCH_COUNT("구매 가격만큼 로또를 구매하셔야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
