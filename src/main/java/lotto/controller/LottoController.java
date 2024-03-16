package lotto.controller;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void lottoStart(){

        final int purchaseAmount =  InputPurchaseAmount.getPurchaseAmount();
        Lotto[] lotto = new Lotto[purchaseAmount];
        for (int i = 0; i < purchaseAmount; i++) {
            lotto[i] = new Lotto(CreateRandomLottoNumbers.createRandomLottoNumbers());
        }
        Lottos lottos = new Lottos(Arrays.stream(lotto).toList());
        printLottoInformation(purchaseAmount,lottos);

        WinningLotto winningLotto = new WinningLotto(InputWinPriceNumber.getWinPriceNumber(), InputWinPriceNumber.getLottoBonusNumber());
        Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);
        printWinningInformation(winningDetails, purchaseAmount);
    }

    private void printLottoInformation(int purchaseAmount, Lottos lottos){
        InputPurchaseAmount.printPurchaseAmount(purchaseAmount);
        Lottos.printLottos(lottos);
    }

    private void printWinningInformation(Map<WinningRank, Integer> winningDetails, int purchaseAmount) {
        OutputView.printWinningStatistics();
        OutputView.printWinningDetails(winningDetails);
        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        OutputView.printLottoYield(WinningStatistics.getLottoYield(winningAmount, purchaseAmount*LOTTO_PRICE));
    }
}
