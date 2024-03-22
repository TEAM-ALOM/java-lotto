package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    public void lottoStart() {
        try {
            int purchaseAmount = InputView.getPurchaseAmount(); // 구매 로또 개수
            LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount); // 구매 개수만큼 로또 발행
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());    // 발행한 로또들 저장
            printLottosInformation(lottoGenerator, lottos); // 구매 개수, 발행한 로또 번호 출력
            WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumber(), InputView.getLottoBonusNumber());  //당첨 번호, 보너스 번호 저장
            Map<WinningRank, Integer> winningDetails = WinningStatistics.getWinningDetails(lottos, winningLotto);   //로또 당첨 통계
            printWinningInformation(winningDetails, purchaseAmount);    //로또 당첨 내역, 수익률 출력

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottosInformation(LottoGenerator lottoGenerator, Lottos lottos) {
        OutputView.printHowManyLottoUserPurchased(lottoGenerator.getLottoQuantity());
        OutputView.printLottos(lottos);
    }

    private void printWinningInformation(Map<WinningRank, Integer> winningDetails, int purchaseAmount) {
        OutputView.printWinningStatistics();
        OutputView.printWinningDetails(winningDetails);
        long winningAmount = WinningStatistics.getWinningAmount(winningDetails);
        OutputView.printLottoYield(WinningStatistics.getLottoYield(winningAmount, purchaseAmount));
    }
}
