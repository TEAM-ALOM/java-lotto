package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Numbers;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static List<Lotto> lottoList;

    public void run() {
        try {
            start();
        } catch (IllegalStateException e) {

        }
    }

    public void start() {
        int money = Integer.parseInt(InputView.inputMyMoney());
        int ticketCount = new LottoNumber(money).count;
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        List<Integer> winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber(winningNumber);

        lottoResult(lottoList, winningNumber, bonusNumber);
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        List<Integer> lotto = new ArrayList<>();
        lotto = Numbers.randomNumbers();
        System.out.println(lotto);

        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> count = findRank(lottoList, winningNumber, bonusNumber);
        printResult(count);
        printRate(count, lottoList.size());
    }

    private Map<Rank, Integer> findRank(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        Map<Rank, Integer> count = setCountZero();

        for (int i = 0; i < lottoList.size(); i++) {
            Rank rank = match(lottoList.get(i), winningNumber, bonusNumber);
            count.put(rank, count.get(rank) + 1);
        }
        return count;
    }

    private Map<Rank, Integer> setCountZero() {
        Map<Rank, Integer> count = new HashMap<>();

        for (Rank rank : Rank.values()) {
            count.put(rank, 0);
        }
        return count;
    }

    private static Rank match(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int countMatch;
        boolean containBonus;
        List<Integer> numbers = lotto.getNumbers();

        countMatch = (int) numbers.stream()
                .filter(winningNumber::contains) // 이중콜론 -> 메서드 참조
                .count();

        containBonus = numbers.contains(bonusNumber);

        return Rank.findRank(countMatch, containBonus);
    }

    private static void printResult(Map<Rank, Integer> count) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(count.get(Rank.values()[i]));
        }
    }

    private static void printRate(Map<Rank, Integer> count, int ticketCount) {
        double rate = 0;
        for (Rank rank : count.keySet()) {
            rate = rate + ((double) (rank.getWinningPrice()) / (ticketCount * 1000) * count.get(rank) * 100);
        }
        OutputView.printRate(rate);
    }
}
