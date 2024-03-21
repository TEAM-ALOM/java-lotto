package lotto.config;

public enum BaseResponseStatus {
    SUCCESS(true, "[SUCCESS] 요청에 성공하였습니다."),
    LOTTO_SIZE_ERROR(false, "[ERROR] 로또 번호 개수가 올바르지 않습니다."),
    LOTTO_NUM_DUPLICATE(false, "[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    INCORRECT_PURCHASE_AMOUNT(false, "[ERROR] 구입 금액이 올바르지 않습니다."),
    NUMBER_RANGE_ERROR(false, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final boolean isSuccess;
    private final String message;

    /**
     * isSuccess : 요청의 성공 또는 실패
     * message : 설명
     */
    BaseResponseStatus(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}