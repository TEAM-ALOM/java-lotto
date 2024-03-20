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

    // 구매 금액 입력
    private int purchaseLotto() {
        return InputView.getPurchaseAmount();
    }

    // 구매한 로또 출력
    private void publishLotto(PurchasedLotto purchasedLotto) {
        OutputView.printLottoCount(purchasedLotto.getLottoCount());
        OutputView.printPublishedLotto(purchasedLotto.getLottoSet());
    }

    // 당첨 번호와 보너스 번호 입력
    private WinningLotto getLottoNumbers() {
        WinningLotto winningLotto = new WinningLotto(InputView.getLottoNumbers());
        winningLotto.setBonusNumber(InputView.getBonusNumber());
        return winningLotto;
    }

    // 당첨 통계 출력
    private void printLottoResult(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = calculateResult(purchasedLotto.getLottoSet(), winningLotto);
        double returnRate = calculateReturnRate(purchasedLotto.getPurchaseAmount(), winningResult);
        OutputView.printWinningResult(winningResult, returnRate);
    }

    // 당첨 통계 계산
    private Map<WinningRank, Integer> calculateResult(List<Lotto> lottoSet, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winningResult.put(winningRank, 0));

        for (Lotto lotto : lottoSet) {
            int match = compareNumbers(lotto.getNumbers(), winningLotto.getWinningNumber());
            boolean containBonus = isContainBonus(lotto.getNumbers(), winningLotto.getBonusNumber(), match);
            WinningRank winningRank = WinningRank.findWinningRank(match, containBonus);
            winningResult.replace(winningRank, winningResult.get(winningRank) + 1);
        }

        return winningResult;
    }

    // 로또 하나의 당첨 결과 계산
    private int compareNumbers(List<Integer> lottoNumber, List<Integer> winningLotto) {
        return (int) lottoNumber.stream().filter(winningLotto::contains).count();
    }

    // 보너스 번호 포함 여부 확인
    private boolean isContainBonus(List<Integer> lottoNumber, int bonus, int match) {
        if (match != 5) return false;
        return lottoNumber.contains(bonus);
    }

    // 수익률 계산
    private double calculateReturnRate(int purchaseAmount, Map<WinningRank, Integer> winningResult) {
        long winningAmount = winningResult.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReword() * entry.getValue())
                .sum();
        return (double) winningAmount / purchaseAmount * 100.0f;
    }
}