package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    private List<Lotto> lottos = new ArrayList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
