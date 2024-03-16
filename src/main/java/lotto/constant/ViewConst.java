package lotto.constant;

public enum ViewConst {

    MONEY_REQUEST("구입금액을 입력해 주세요."),
    PURCHASE_RESPONSE("개를 구매했습니다."),
    WINNING_NUMBER_REQUEST("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n---"),
    THREE_WIN("3개 일치 (" + LottoConst.FIFTH_PLACE_PRIZE.getDecimalFormatMoney() + ") - "),
    FOUR_WIN("4개 일치 (" + LottoConst.FOURTH_PLACE_PRIZE.getDecimalFormatMoney() + ") - "),
    FIFTH_WIN("5개 일치 (" + LottoConst.THIRD_PLACE_PRIZE.getDecimalFormatMoney() + ") - "),
    FIFTH_WIN_WITH_BONUS("5개 일치, 보너스 볼 일치 (" + LottoConst.SECOND_PLACE_PRIZE.getDecimalFormatMoney() + ") - "),
    SIXTH_WIN("6개 일치 (" + LottoConst.FIRST_PLACE_PRIZE.getDecimalFormatMoney() + ") - ");

    private final String message;

    ViewConst(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
