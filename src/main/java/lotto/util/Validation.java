package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final String INPUT_LOTTO_PRICE_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    private static final String INPUT_TYPE_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_LOTTO_SIZE_ERROR = "[ERROR] 당첨 번호는 서로 다른 6개의 수로 입력해주세요.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR = "[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.";
    private static final String INPUT_BONUS_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_BONUS_DUPLICATED_ERROR = "[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.";

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static int validateMoney(String purchasedAmount) {
        int money = validateMoneyType(purchasedAmount);
        validateMoneyRange(money);
        return money;
    }

    private static int validateMoneyType(String purchasedAmount) {
        try {
            return Integer.parseInt(purchasedAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_RANGE_ERROR);
        }
    }

    private static void validateMoneyRange(int purchasedAmount) {
        if (purchasedAmount <= ZERO || purchasedAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_LOTTO_PRICE_ERROR);
        }
    }

    public static void validateLotto(List<Integer> lotto) {
        validateLottoNumber(lotto);
        validateLottoNumberSize(lotto);
        validateDuplicateLottoNumber(lotto);
    }

    private static void validateLottoNumber(List<Integer> lotto) {
        for (Integer l : lotto) {
            if (l < LOTTO_MIN_NUMBER || l > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(INPUT_TYPE_RANGE_ERROR);
            }
        }
    }

    private static void validateLottoNumberSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_LOTTO_SIZE_ERROR);
        }
    }

    private static void validateDuplicateLottoNumber(List<Integer> lotto) {
        Set<Integer> deduplicate = new HashSet<>(lotto);
        if (deduplicate.size() != lotto.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
    }

    public static void validateBonus(List<Integer> lotto, int bonus) {
        validateBonusNumber(bonus);
        validateDuplicateLottoBonus(lotto, bonus);
    }

    private static void validateBonusNumber(int bonus) {
        if (bonus < LOTTO_MIN_NUMBER || bonus > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_BONUS_RANGE_ERROR);
        }
    }

    private static void validateDuplicateLottoBonus(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_BONUS_DUPLICATED_ERROR);
        }
    }
}
