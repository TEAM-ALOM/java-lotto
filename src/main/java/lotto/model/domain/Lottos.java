package lotto.model.domain;

import static lotto.validation.ErrorMessage.LOTTOS_COUNT_OUT_OF_RANGE_100;
import static lotto.validation.ErrorMessage.LOTTOS_SIZE_NOT_MATCH_COUNT;

import java.util.List;

public class Lottos {
    private final int count;
    private final List<Lotto> lottos;

    public Lottos(int count, List<Lotto> lottos) {
        validationCount(count);
        this.count = count;
        validationLottos(count, lottos);
        this.lottos = lottos;
    }

    private void validationCount(int count) {
        checkCountUnder100(count);
    }

    private void checkCountUnder100(int count) {
        if (count > 100) {
            throw new IllegalArgumentException(LOTTOS_COUNT_OUT_OF_RANGE_100.getMessage());
        }
    }

    private void validationLottos(int count, List<Lotto> lottos) {
        checkLottosSizeSameCount(count, lottos);
    }

    private static void checkLottosSizeSameCount(int count, List<Lotto> lottos) {
        if (lottos.size() != count) {
            throw new IllegalArgumentException(LOTTOS_SIZE_NOT_MATCH_COUNT.getMessage());
        }
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
