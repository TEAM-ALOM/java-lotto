package lotto.util;

import lotto.constant.ExceptionConst;

import java.util.List;

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

    static public List<Integer> isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionConst.LOTTO_COUNT_EXCEPTION.getMessage());
        }
        return numbers;
    }

    static public void isInRange(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(ExceptionConst.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }
}
