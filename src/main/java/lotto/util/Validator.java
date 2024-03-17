package lotto.util;

import java.util.List;

import static lotto.util.Constants.MAX_NUM;
import static lotto.util.Constants.MIN_NUM;
import static lotto.util.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.util.ExceptionMessage.NOT_INT;

public abstract class Validator {
    abstract void validate(String input) throws IllegalStateException;
//    abstract void validate(String input, List<Integer> winningNums) throws IllegalStateException;

    void validateInt(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }

    void validateLottoNumberRange(String lottoNumber){
        int num= Integer.parseInt(lottoNumber);
        if (num< MIN_NUM || num>MAX_NUM){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
