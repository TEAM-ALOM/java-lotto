package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    public void lottoStart() {
        try {
            int pruchaseAmount = InputView.getPurchaseAmount();
            LottoGenerator lottoGenerator = new LottoGenerator(pruchaseAmount);
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());
            printLottosInfromation(lottoGenerator, lottos);
            WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumber(), InputView.getLottoBonusNumber());
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);
            printWinningInformation(winningDetails, pruchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottosInfromation(LottoGenerator lottoGenerator, Lottos lottos) {
        OutputView.printHowManyLottosUserPurchased(lottoGenerator.getLottoQuantity());
        OutputView.printLottos(lottos);
    }

    private void printWinningInformation(Map<WinningRank, Integer> winningDetails, int purchaseAmount) {
        OutputView.printWinningStatistics();
        OutputView.printWinningDetails(winningDetails);
        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        OutputView.printLottoYield(WinningStatistics.getLottoYield(winningAmount, purchaseAmount));
    }
}
