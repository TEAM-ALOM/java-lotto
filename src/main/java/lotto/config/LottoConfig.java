package lotto.config;

import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;

public class LottoConfig {
    public LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }


}
