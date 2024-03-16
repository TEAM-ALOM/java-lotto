package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;

public enum ExceptionMessage {
    NOT_INT("정수를 입력해주세요"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_MONEY_UNIT(String.format("%d원 단위로 구매해야합니다.", LOTTO_PRICE)),
    ZERO_EXCEPTION("0보다 큰 금액을 입력해주세요"),
    INVALID_WINNING_SIZE("6개의 번호를 입력해주세요."),
    INVALID_WINNING_NUMBER_DUPLICATE("중복되지 않은 6개의 번호를 입력해주세요."),
    INVALID_BONUS_NUM("보너스가 번호가 정규번호와 중복되었습니다.");

    public static final String BASE_MESSAGE="[ERROR] %s";
    private final String message;

    ExceptionMessage(String message){
        this.message= String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
