package lotto.config;


public class BaseResponse<T> {

    private final Boolean isSuccess;
    private final String message;
    private T result;

    /**
     * 요청 성공 시
     * Ex) return new BaseResponse<>(signUpUserRes);
     * @param result
     */
    public BaseResponse(T result) {
        this.isSuccess = BaseResponseStatus.SUCCESS.isSuccess();
        this.message = BaseResponseStatus.SUCCESS.getMessage();
        this.result = result;
    }

    /**
     * 요청 실패 시
     * Ex) return new BaseResponse<>(BaseResponseStatus.DATABASE_INSERT_ERROR);
     * @param status
     */
    public BaseResponse(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
    }

    /**
     * 직접 설정할 수 있게 생성자 만듦
     * Ex) return new BaseResponse<>(false, 401, "권한이 없습니다.")
     * @param isSuccess
     * @param message
     */
    public BaseResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}