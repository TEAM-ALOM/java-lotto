package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;

import java.util.List;

public interface LottoService {
    public void buyLottos(Integer money);

    public List<Lotto> findAll();

    public LottoResultDto calculateLottos(WinningLotto winningLotto);

}
