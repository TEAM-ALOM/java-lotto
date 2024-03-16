package lotto.util;

public class BonusNumValidator extends Validator{
    @Override
    public void validate(String input) throws IllegalStateException {
        validateInt(input);
        validateLottoNumberRange(input);
    }
}
