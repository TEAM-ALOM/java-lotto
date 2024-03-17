package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinnigResult;
import lotto.util.Constants;
import lotto.util.ExceptionMessage;
import lotto.util.LottoGenerator;
import lotto.util.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        try {
            int money=inputView.readMoney();
            LottoGenerator lottoGenerator = new LottoGenerator();

            List<Lotto> lottos = lottoGenerator.generate(money);
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            int bonusNum = inputView.readBonusNumber(winningNumbers);
            WinnigResult winnigResult = new WinnigResult(new Lotto(winningNumbers), bonusNum);
            lottoResult(lottos, winnigResult, money / 1000);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private void lottoResult(List<Lotto> lottoList, WinnigResult winnigResult, int ticketNum){
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winnigResult.match(lottoList.get(i));

            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, ticketNum);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * Constants.LOTTO_PRICE) * (result.get(
                            rank)) * (100));

        }
        OutputView.printRevenueRate(EarningRate);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
