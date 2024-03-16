package lotto.service;

import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.LottoGenerator;

import java.util.Collections;
import java.util.List;

public class LottoServiceImpl {
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void buyLottos(Long money) {
        long count = money / 1000;
        while (count != 0) {
            List<Integer> numbers = LottoGenerator.generateLotto();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoRepository.save(lotto);
            count--;
        }
    }
}
