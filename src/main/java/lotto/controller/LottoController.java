package lotto.controller;

import lotto.domain.PurchaseLotto;
import lotto.domain.ResultLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    public void gameStart() {
        PurchaseLotto purchaseLotto = InputView.inputPrice();
        OutputView.printPurchaseLotto(purchaseLotto);

        WinningLotto winningLotto = InputView.inputWinningLotto();

        Map<ResultLotto, Integer> resultLotto = purchaseLotto.matchWinningLotto(winningLotto);
        OutputView.printResult(resultLotto);
        OutputView.printProfit(purchaseLotto.calculateProfit(resultLotto));
    }
}
