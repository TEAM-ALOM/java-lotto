package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final String INPUT_LOTTO_PRICE_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_LOTTO_SIZE_ERROR = "[ERROR] 당첨 번호는 서로 다른 6개의 수로 입력해주세요.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR = "[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.";
    private static final String INPUT_BONUS_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_BONUS_DUPLICATED_ERROR = "[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.";

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    // 입력된 타입 확인
    public static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR);
        }
    }

    // 구매 금액은 0이상, 1000원 단위
    public static void validateMoneyRange(int purchasedAmount) {
        if (purchasedAmount <= ZERO || purchasedAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_LOTTO_PRICE_ERROR);
        }
    }

    // 로또 번호 적합성
    public static void validateLotto(List<Integer> lotto) {
        validateLottoNumber(lotto);
        validateLottoNumberSize(lotto);
        validateDuplicateLottoNumber(lotto);
    }

    // 로또 번호는 1~45
    private static void validateLottoNumber(List<Integer> lotto) {
        for (Integer l : lotto) {
            if (l < LOTTO_MIN_NUMBER || l > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
            }
        }
    }

    // 로또는 6개의 숫자
    private static void validateLottoNumberSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_LOTTO_SIZE_ERROR);
        }
    }

    // 로또 번호는 중복 없음
    public static void validateDuplicateLottoNumber(List<Integer> lotto) {
        Set<Integer> deduplicate = new HashSet<>(lotto);
        if (deduplicate.size() != lotto.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
    }

    // 보너스 번호 적합성
    public static void validateBonus(List<Integer> lotto, int bonus) {
        validateBonusNumber(bonus);
        validateDuplicateLottoBonus(lotto, bonus);
    }

    // 보너스 번호는 1~45
    private static void validateBonusNumber(int bonus) {
        if (bonus < LOTTO_MIN_NUMBER || bonus > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_BONUS_RANGE_ERROR);
        }
    }

    // 보너스 번호는 당첨 번호와 중복 없음
    private static void validateDuplicateLottoBonus(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_BONUS_DUPLICATED_ERROR);
        }
    }
}
