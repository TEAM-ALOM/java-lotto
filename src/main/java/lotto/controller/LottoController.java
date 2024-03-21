package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputWinningLottoView;

import java.util.List;

import static lotto.view.outputBuyLottoCount.printBuyLotto;
import static lotto.view.outputLottoList.printLottoList;
import static lotto.view.outputStatistics.printStatistics;

public class LottoController {

    // 프로그램 시작 지점
    public void start() {
        // 로또 구매 금액 입력
        Money money = getLottoMoney();
        printBuyLotto(money); // 구매한 로또 티켓 수 출력

        // 로또 구매
        Lottos lottos = getLottos(money);
        printLottoList(lottos); // 구매한 로또 목록 출력

        // 당첨 번호 입력
        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();

        // 로또 당첨 결과 계산
        calcLottoResult(prizeResult, winningLotto, lottos);

        // 수익률 계산
        Rate rate = getRate(money, prizeResult);

        // 통계 출력
        printStatistics(prizeResult, rate);
    }

    // 로또 구매 금액 입력
    private Money getLottoMoney() {
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    // 로또 구매
    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getTicket()));
    }

    // 당첨 번호 입력
    private WinningLotto getWinningLotto() {
        InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningLottoView.getValue();
        Integer bonusNumber = inputBonusNumberView.getValue();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    // 로또 당첨 결과 계산
    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    // 수익률 계산
    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }
}
