package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseLotto());
        publishLotto(purchasedLotto);
        WinningLotto winningLotto = getLottoNumbers();
        printLottoResult(purchasedLotto, winningLotto);
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

    private void printLottoResult(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = calculateResult(purchasedLotto.getLottoSet(), winningLotto);
        double returnRate = calculateReturnRate(purchasedLotto.getPurchaseAmount(), winningResult);
        OutputView.printWinningResult(winningResult, returnRate);
    }

    private Map<WinningRank, Integer> calculateResult(List<Lotto> lottoSet, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winningResult.put(winningRank, 0));

        for (Lotto lotto : lottoSet) {
            int match = compareNumbers(lotto.getNumbers(), winningLotto.getWinningNumber());
            boolean containBonus = isContainBonus(lotto.getNumbers(), winningLotto.getBonusNumber());
            WinningRank winningRank = WinningRank.findWinningRank(match, containBonus);
            winningResult.replace(winningRank, winningResult.get(winningRank) + 1);
        }

        return winningResult;
    }

    private int compareNumbers(List<Integer> lottoNumber, List<Integer> winningLotto) {
        return (int) lottoNumber.stream().filter(winningLotto::contains).count();
    }

    private boolean isContainBonus(List<Integer> lottoNumber, int bonus) {
        return lottoNumber.contains(bonus);
    }

    private double calculateReturnRate(int purchaseAmount, Map<WinningRank, Integer> winningResult) {
        long winningAmount = winningResult.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReword() * entry.getValue())
                .sum();
        return (double) winningAmount / purchaseAmount * 100.0f;
    }
}