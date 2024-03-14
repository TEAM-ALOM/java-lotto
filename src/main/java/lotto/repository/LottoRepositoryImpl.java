package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl {
    private List<Lotto> lottos = new ArrayList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
