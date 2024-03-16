package lotto.controller;

import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.*;

import java.util.Map;

public class LottoController {

    public void lottoStart() {
        try {
            int money = InputView.getPurchaseAmount(); //금액 입력
            LottoGenerator lottoGenerator = new LottoGenerator(money);
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());    //개수만큼 로또 생성

            OutputView.printHowManyLottoUserPurchased(lottoGenerator.getLottoQuantity());
            OutputView.printLottos(lottos); //구매 개수랑 출력

            LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(InputView.getWinningNums(), InputView.getBonusNum());
            Map<WinningRank, Integer> winningDetails = WinningDetails.getWinningDetails(lottos, lottoWinningNumber);

            OutputView.printWinningDetails(winningDetails);
            long profit = WinningDetails.getProfit(winningDetails);
            OutputView.printProfitRate(WinningDetails.getProfitRate(profit, money));    //당첨결과, 수익률
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
