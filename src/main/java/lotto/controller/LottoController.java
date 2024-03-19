package lotto.controller;

import lotto.domain.PurchasedLotto;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseLotto());
        publishLotto();
        getLottoNumbers();
        printLottoResult();
    }

    private int purchaseLotto() {
        return InputView.getPurchaseAmount();
    }

    private void publishLotto() {

    }

    private void getLottoNumbers() {

    }

    private void printLottoResult() {

    }
}