package lotto.validation;

import static lotto.validation.ErrorMessage.BONUS_NUMBER_IS_DUPLICATED;
import static lotto.validation.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTOS_COUNT_OUT_OF_RANGE_100;
import static lotto.validation.ErrorMessage.LOTTOS_SIZE_NOT_MATCH_COUNT;
import static lotto.validation.ErrorMessage.LOTTO_HAS_DUPLICATED_NUMBER;
import static lotto.validation.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTO_SIZE_NOT_SIX;
import static lotto.validation.ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER;
import static lotto.validation.ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_DOUBLE_COMMA;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_END_WITH_COMMA;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_START_WITH_COMMA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.domain.Lotto;
import lotto.model.domain.WinningType;

public class Validation {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validationLotto(List<Integer> numbers) {
        checkSizeOnlySix(numbers);
        checkNumberOutOfRange(numbers);
        checkDuplicatedNumber(numbers);
    }


    public static void validationCount(int count) {
        checkCountUnder100(count);
    }

    public static void validationProfitRatio(double profitRatio) {
        checkMaxProfitRatio(profitRatio);
    }


    public static void validationMoney(int money) {
        checkMoneyOutOfRange(money);
        checkMoneyDivisibility(money);
    }

    public static void validationBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        checkNumberOutOfRange(bonusNumber);
        checkDuplicatedBonusNumber(winningLotto, bonusNumber);
    }


    public static void checkPossibleChangeToInt(String moneyForPurchase) {
        try {
            Integer.parseInt(moneyForPurchase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
        }
    }

    public static void checkRightCommaFormat(String winningNumbers) {
        if (winningNumbers.startsWith(",")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_START_WITH_COMMA.getMessage());
        }
        if (winningNumbers.endsWith(",")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_END_WITH_COMMA.getMessage());
        }
        if (winningNumbers.contains(",,")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_DOUBLE_COMMA.getMessage());
        }
    }


    public static void checkStatusValueMinus(int lottosWinningStatusValue) {
        if (lottosWinningStatusValue < 0) {
            throw new IllegalArgumentException(OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());
        }
    }

    public static void checkStatusValueMinus(double lottosWinningStatusValue) {
        if (lottosWinningStatusValue < 0) {
            throw new IllegalArgumentException(OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());
        }
    }

    private static void checkDuplicatedBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private static void checkNumberOutOfRange(int bonusNumber) {
        if (isNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static boolean isNumberOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }


    private static void checkMoneyDivisibility(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkMoneyOutOfRange(int money) {
        if (money < 0 || money > 100000) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkMaxProfitRatio(double profitRatio) {
        if (profitRatio > (double) WinningType.MATCHES_SIX.getProfitMoney() * 100 / 1000) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_STATUS_PROFIT_RATIO_OVER_MAX.getMessage());
        }
    }

    private static void checkCountUnder100(int count) {
        if (count > 100) {
            throw new IllegalArgumentException(LOTTOS_COUNT_OUT_OF_RANGE_100.getMessage());
        }
    }

    public static void validationLottos(int count, List<Lotto> lottos) {
        checkLottosSizeSameCount(count, lottos);
    }

    private static void checkLottosSizeSameCount(int count, List<Lotto> lottos) {
        if (lottos.size() != count) {
            throw new IllegalArgumentException(LOTTOS_SIZE_NOT_MATCH_COUNT.getMessage());
        }
    }

    private static void checkSizeOnlySix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_NOT_SIX.getMessage());
        }
    }

    private static void checkNumberOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isNumberOutOfRange(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersNotDupl = new HashSet<>();
        for (Integer number : numbers) {
            checkAndAddNumber(numbersNotDupl, number);
        }
    }

    private static void checkAndAddNumber(Set<Integer> numbersNotDupl, Integer number) {
        if (numbersNotDupl.contains(number)) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATED_NUMBER.getMessage());
        }
        numbersNotDupl.add(number);
    }

}
