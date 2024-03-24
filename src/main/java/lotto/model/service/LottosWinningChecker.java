package lotto.model.service;

import static lotto.model.domain.WinningType.MATCHES_FIVE;
import static lotto.model.domain.WinningType.MATCHES_FIVE_WITH_BONUS;
import static lotto.model.domain.WinningType.MATCHES_FOUR;
import static lotto.model.domain.WinningType.MATCHES_SIX;
import static lotto.model.domain.WinningType.MATCHES_THREE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoUser;
import lotto.model.domain.Lottos;
import lotto.model.domain.LottosWinningStatus;
import lotto.model.domain.WinningNumbers;

public class LottosWinningChecker {

    public static LottosWinningStatus generateWinningStatusAndInput(LottoUser lottoUser,
                                                                    WinningNumbers winningNumbers) {
        Lottos lottos = lottoUser.getLottos();

        AtomicInteger matchesThree = new AtomicInteger();
        AtomicInteger matchesFour = new AtomicInteger();
        AtomicInteger matchesFive = new AtomicInteger();
        AtomicInteger matchesFiveWithBonus = new AtomicInteger();
        AtomicInteger matchesSix = new AtomicInteger();

        lottos.getLottos().forEach(lotto -> {
                    int matchesCount = getMatchesCount(lotto.getNumbers(), winningNumbers.getWinningLotto().getNumbers());
                    stackByMatchesCount(lotto, matchesCount, matchesThree, matchesFour, matchesFiveWithBonus, matchesFive,
                            matchesSix, winningNumbers);
                }
        );

        return getWinningStatus(matchesThree, matchesFour, matchesFive, matchesFiveWithBonus, matchesSix, lottoUser);

//        inputWinningStatusToUser(matchesThree, matchesFour, matchesFive, matchesFiveWithBonus, matchesSix);
    }

    private static LottosWinningStatus getWinningStatus(AtomicInteger matchesThree, AtomicInteger matchesFour,
                                                        AtomicInteger matchesFive,
                                                        AtomicInteger matchesFiveWithBonus, AtomicInteger matchesSix,
                                                        LottoUser lottoUser) {
        return new LottosWinningStatus(
                matchesThree.intValue(),
                matchesFour.intValue(),
                matchesFive.intValue(),
                matchesFiveWithBonus.intValue(),
                matchesSix.intValue(),

                calculateProfitRatio(matchesThree,
                        matchesFour,
                        matchesFive,
                        matchesFiveWithBonus,
                        matchesSix, lottoUser)
        );
    }

    private static double calculateProfitRatio(AtomicInteger matchesThree, AtomicInteger matchesFour,
                                               AtomicInteger matchesFive,
                                               AtomicInteger matchesFiveWithBonus, AtomicInteger matchesSix,
                                               LottoUser lottoUser) {
        return (double) getTotalProfitMoney(matchesThree, matchesFour, matchesFive, matchesFiveWithBonus, matchesSix)
                / lottoUser.getMoney();
    }

    private static long getTotalProfitMoney(AtomicInteger matchesThree, AtomicInteger matchesFour,
                                            AtomicInteger matchesFive,
                                            AtomicInteger matchesFiveWithBonus, AtomicInteger matchesSix) {
        return matchesThree.intValue() * MATCHES_THREE.getProfitMoney()
                + matchesFour.intValue() * MATCHES_FOUR.getProfitMoney()
                + matchesFive.intValue() * MATCHES_FIVE.getProfitMoney()
                + matchesFiveWithBonus.intValue() * MATCHES_FIVE_WITH_BONUS.getProfitMoney()
                + matchesSix.intValue() * MATCHES_SIX.getProfitMoney();
    }

    private static void stackByMatchesCount(Lotto lotto, int matchesCount, AtomicInteger matchesThree,
                                            AtomicInteger matchesFour, AtomicInteger matchesFiveWithBonus,
                                            AtomicInteger matchesFive, AtomicInteger matchesSix,
                                            WinningNumbers winningNumbers) {
        switch (matchesCount) {
            case 3:
                matchesThree.getAndIncrement();
                break;
            case 4:
                matchesFour.getAndIncrement();
                break;
            case 5:
                if (isMatchToBonusNumber(lotto, winningNumbers)) {
                    matchesFiveWithBonus.getAndIncrement();
                    break;
                }
                matchesFive.getAndIncrement();
                break;
            case 6:
                matchesSix.getAndIncrement();
                break;
        }
    }

    private static boolean isMatchToBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    private static int getMatchesCount(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }
}

//3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개