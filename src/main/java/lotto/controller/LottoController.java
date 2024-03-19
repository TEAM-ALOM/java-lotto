package lotto.controller;

import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseLotto());
        publishLotto(purchasedLotto);
        WinningLotto winningLotto = getLottoNumbers();
        printLottoResult();
    }

    private int purchaseLotto() {
        return InputView.getPurchaseAmount();
    }

    private void publishLotto(PurchasedLotto purchasedLotto) {
        OutputView.printLottoCount(purchasedLotto.getLottoCount());
        OutputView.printPublishedLotto(purchasedLotto.getLottoSet());
    }

    private WinningLotto getLottoNumbers() {
        List<Integer> winningNumber = InputView.getLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private void printLottoResult() {

    }
}