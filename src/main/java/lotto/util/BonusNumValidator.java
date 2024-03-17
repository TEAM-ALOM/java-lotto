package lotto.util;

import java.util.List;

public class BonusNumValidator extends Validator{
    @Override
    public void validate(String input) throws IllegalStateException {
        validateInt(input);
        validateLottoNumberRange(input);
    }

}
