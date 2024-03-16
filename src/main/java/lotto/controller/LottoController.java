package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseDto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public List<Lotto> buyLottos(Integer money) {
        return lottoService.buyLottos(money);
    }

    public void playLotto() {
        Integer money = inputView.readMoney();
        List<Lotto> lottos = buyLottos(money);
        LottoPurchaseDto lottoPurchaseDto = new LottoPurchaseDto(lottos);
        outputView.displayPurchaseResult(lottoPurchaseDto);
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        Integer bonusNumber = inputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResultDto lottoResultDto = lottoService.calculateLottos(winningLotto, money);
        Map<Integer, Integer> result = lottoResultDto.getResult();
        outputView.displayWinningResult(lottoResultDto);
    }
}
