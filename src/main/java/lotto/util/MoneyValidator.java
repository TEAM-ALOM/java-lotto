package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.ExceptionMessage.*;

public class MoneyValidator extends Validator{
    @Override
    public void validate(String money) throws IllegalStateException {
        validateInt(money);
        validateMoneyUnit(money);
        validateIsZero(money);
    }

    private void validateMoneyUnit(String money){
        if (Integer.parseInt(money)% LOTTO_PRICE!=0){
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    private void validateIsZero(String money){
        if(Integer.parseInt(money)==0){
            throw new IllegalArgumentException(ZERO_EXCEPTION.getMessage());
        }
    }

}
