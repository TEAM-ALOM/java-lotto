package lotto.controller;

import lotto.domain.PurchaseLotto;
import lotto.domain.ResultLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    public void gameStart() {
        // 로또 구매 금액을 입력 받고, 구매한 로또들을 생성한다.
        PurchaseLotto purchaseLotto = InputView.inputPrice();
        // 생성된 로또를 문자열로 변환하고 출력한다.
        OutputView.printPurchaseLotto(purchaseLotto);

        WinningLotto winningLotto = InputView.inputWinningLotto();

        /*
        resultLotto에
        MISS 0
        FIFRH 2
        ...
        FIRST 1
        로 생성됨
        (5등 2번, 1등 1번 당첨됐다는 뜻)
        */
        Map<ResultLotto, Integer> resultLotto = purchaseLotto.matchWinningLotto(winningLotto);
        OutputView.printResult(resultLotto);
        OutputView.printProfit(purchaseLotto.calculateProfit(resultLotto));
    }
}
