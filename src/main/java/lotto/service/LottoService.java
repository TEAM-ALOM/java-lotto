package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;

import java.util.List;

public interface LottoService {
    public List<Lotto> buyLottos(Integer money);

    public List<Lotto> findAll();

    public LottoResultDto calculateLottos(WinningLotto winningLotto, Integer money);

    public Integer calculateLotto(Lotto lotto, WinningLotto winningLotto);

    public Integer calculateRank(int count, Boolean hasBonus);

    public Double calculateRate(LottoResultDto lottoResultDto, Integer money);
}
