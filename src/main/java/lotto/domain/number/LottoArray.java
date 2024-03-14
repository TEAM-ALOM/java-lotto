package lotto.domain.number;

import java.util.List;

public class LottoArray {
    private List<Lotto> lottoArray;

    public LottoArray(List<Lotto> lottoArray) {
        this.lottoArray = lottoArray;
    }

    public List<Lotto> getLottoArray() {
        return lottoArray;
    }
}
