package lotto.model.domain;

import java.util.List;
import lotto.validation.Validation;

public class Lottos {
    private final int count;
    private final List<Lotto> lottoBundle;

    public Lottos(int count, List<Lotto> lottoBundle) {
        Validation.validationCount(count);
        this.count = count;
        Validation.validationLottos(count, lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
