package controller;

import lotto.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoController {
    public void startLotto() {
        try {
            int cost = InputView.buyLotto();
            GenerateLotto generateLotto = new GenerateLotto(cost);
            Lottos lottos = new Lottos(generateLotto.generateLottos());

            OutputView.printHowManyLottoUserPurchased(generateLotto.getCount());
            OutputView.printLottos(lottos);

            WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumber(), InputView.getLottoBonusNumber());
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);

            OutputView.printWinningStatistics();
            OutputView.printWinningDetails(winningDetails);
            long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
            OutputView.printLottoYield(WinningStatistics.getLottoYield(winningAmount, cost));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
