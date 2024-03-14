package lotto.exception;

public enum ExceptionConst {

    NOT_ENOUGH_MONEY_EXCEPTION("[ERROR] 금액이 부족합니다."),
    NOT_INTEGER_INPUT_EXCEPTION("[ERROR] 입력은 숫자만 받을 수 있습니다."),
    UNIT_EXCEPTION("[ERROR] 금액은 1,000원 단위로 입력해야 합니다."),
    LOTTO_COUNT_EXCEPTION("[ERROR] 보너스 번호를 제외한 번호는 6개여야 합니다."),
    SEPARATION_EXCEPTION("[ERROR] 구분은 쉼표로 해야합니다."),
    NUMBER_RANGE_EXCEPTION("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");


    private final String message;

    ExceptionConst(String message) {
        this.message = message;
    }
}
