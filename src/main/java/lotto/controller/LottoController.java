package lotto.controller;

import lotto.domain.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseLotto());
        publishLotto(purchasedLotto);
        getLottoNumbers();
        printLottoResult();
    }

    private int purchaseLotto() {
        return InputView.getPurchaseAmount();
    }

    private void publishLotto(PurchasedLotto purchasedLotto) {
        OutputView.printLottoCount(purchasedLotto.getLottoCount());
        OutputView.printPublishedLotto(purchasedLotto.getLottoSet());
    }

    private void getLottoNumbers() {

    }

    private void printLottoResult() {

    }
}