package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoRepository {
    public void save(Lotto lotto);

    public List<Lotto> findAll();
}
