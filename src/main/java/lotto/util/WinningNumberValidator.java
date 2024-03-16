package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATE;
import static lotto.util.ExceptionMessage.INVALID_WINNING_SIZE;

public class WinningNumberValidator extends Validator{
    @Override
    public void validate(String input) throws IllegalStateException {
        List<String> winnigNumbers = new ArrayList<>(List.of(input.split(",")));
        validateWinningNumberSize(winnigNumbers);
        validateWinningNumberDuplicate(winnigNumbers);
        for (String winnigNumber : winnigNumbers) {
            validateInt(winnigNumber);
            validateLottoNumberRange(winnigNumber);
        }

    }
    private void validateWinningNumberSize(List<String> winngNumbers){
        if (winngNumbers.size()!=Constants.NUM_COUNT){
            throw new IllegalArgumentException(INVALID_WINNING_SIZE.getMessage());
        }
    }

    private void validateWinningNumberDuplicate(List<String> winningNumbers){
        Set<String > set = new HashSet<>(winningNumbers);
        if (set.size()!=6){
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
}
