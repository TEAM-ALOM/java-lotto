package lotto.util;

import lotto.exception.ExceptionConst;

public class ValidationFilter {

    static public Integer isNumber(String money) {
        int m;
        try {
            m = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConst.NOT_INTEGER_INPUT_EXCEPTION.getMessage());
        }
        return m;
    }
}
