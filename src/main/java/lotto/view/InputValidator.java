package lotto.view;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputValidator {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "유효하지 않은 숫자 형식입니다.";
    private static final String INVALID_AMOUNT_MESSAGE = "유효하지 않은 구입 금액입니다.";
    private static final int VALID_LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int VALID_LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int VALID_LOTTO_NUMBERS_SIZE = 6;
    private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "올바른 로또 번호가 아닙니다.";
    private static final String DISTINCT_BONUS_NUMBERS_MESSAGE = "보너스 번호는 로또 번호와 다른 번호를 입력해야 합니다.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static Integer validateBuyAmount(String inputAmount){
        Integer amount = toInteger(inputAmount);
        validateAmountRange(amount);
        return amount;
    }

    public static Integer toInteger(String number){ //숫자 형식 체크
        try{
            return Integer.valueOf(number);
        }
        catch(NumberFormatException e){
            throw new IllegalStateException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    public static void validateAmountRange(Integer amount){
        if(amount < 1000 || amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> validateWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = getDistinctWinningNumbers(inputWinningNumbers);
        validateWinningNumbersSize(winningNumbers);
        return winningNumbers;
    }
    private static List<Integer> getDistinctWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(InputValidator::toInteger)
                .filter(InputValidator::isValidLottoNumberRange)
                .distinct()
                .collect(toList());
    }

    private static boolean isValidLottoNumberRange(Integer number) {
        return VALID_LOTTO_NUMBER_LOWER_BOUND <= number && number <= VALID_LOTTO_NUMBER_UPPER_BOUND;
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != VALID_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public static Integer validateBonusNumber(List<Integer> winningNumbers, String inputBonusNumbers) {
        Integer bonusNumber = toInteger(inputBonusNumbers);
        validateWinningNumbersNotContainBonusNumber(winningNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateWinningNumbersNotContainBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DISTINCT_BONUS_NUMBERS_MESSAGE);
        }
    }

    private static void validateBonusNumberRange(Integer bonusNumber) {
        if (!isValidLottoNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }
    }


}
