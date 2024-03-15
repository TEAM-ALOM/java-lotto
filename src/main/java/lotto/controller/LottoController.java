package lotto.controller;

import lotto.domain.betting.Betting;
import lotto.domain.number.LottoArray;
import lotto.domain.number.LottoMachine;
import lotto.domain.number.WinningNumbers;
import lotto.domain.result.EarningsRate;
import lotto.domain.result.MatchedPlace;
import lotto.domain.result.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        try{
            final Betting betting = new Betting(getBetting());
            final int amount = betting.getAmount();
            LottoMachine lottoMachine = new LottoMachine(amount);
            LottoArray lottoArray = new LottoArray(lottoMachine.createLottoArray());
            printLotto(lottoMachine, lottoArray);

            final WinningNumbers winningNumbers =
                    new WinningNumbers(getWinningArray(),getBonusNumber());
            Map<MatchedPlace, Integer> matchedDetails = Result.getMatchedDetails(lottoArray, winningNumbers);
            printResult(matchedDetails,amount);
        }catch(IllegalArgumentException e) {
            System.out.println((e.getMessage()));
        }

    }
    private String getBetting() {
        return InputView.readMoney();
    }
    private List<Integer> getWinningArray() {
        return InputView.readWinningArray();
    }
    private String getBonusNumber() {
        return InputView.readBonusNumber();
    }
    private void printLotto(LottoMachine lottoMachine,LottoArray lottoArray) {
        OutputView.printLottoTicketNumber(lottoMachine.getTicketNumber());
        OutputView.printLotto(lottoArray);
    }

    private void printResult(Map<MatchedPlace, Integer> matchedDetails, int amount) {
        OutputView.printStatistics();
        OutputView.printMatchedDetails(matchedDetails);
        long winningAmount = EarningsRate.getEarning(matchedDetails);
        OutputView.printEarningsRate(EarningsRate.getEarningsRate(winningAmount, amount));
    }
}
