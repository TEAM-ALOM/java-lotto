package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningDetails {

    public static Map<WinningRank, Integer> getWinningDetails(Lottos lottos, LottoWinningNumber lottoWinningNumber) {
        Map<WinningRank, Integer> winningDetails = generateWinningDetails();
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = compareWithWinningNums(lotto, lottoWinningNumber);
            boolean containsBonusNum = compareWithBonusNum(lotto, lottoWinningNumber, matchCount);
            WinningRank winningRank = WinningRank.findWinningRank(matchCount, containsBonusNum);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }
        return winningDetails;
    }

//    찾아볼필요가..
    public static long getProfit(Map<WinningRank, Integer> winningDetails) {
        return winningDetails.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

//    수익률 구하는 방법이 뭐지
    public static double getProfitRate(long profit, int money) {
        double profitRate = 100 + (double) (profit - money) / money * 100;
        return Math.round(profitRate * 10) * 10.0;
    }




    private static Map<WinningRank, Integer> generateWinningDetails() {
        Map<WinningRank, Integer> winningDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values())
                .forEach(winningRank -> winningDetails.put(winningRank, 0));
        return winningDetails;
    }


//    로또 1개와 당첨번호 비교, 일치하는 개수 찾기(스트림 필터)
    private static int compareWithWinningNums(Lotto lotto, LottoWinningNumber lottoWinningNumber) {
        List<Integer> nums = lotto.getNumbers();
        List<Integer> winningNums = lottoWinningNumber.getWinningNums();
        return (int) nums.stream()
                .filter(winningNums::contains)
                .count();
    }

//    5개 일치 시에만 보너스 번호 필요
    private static boolean compareWithBonusNum(Lotto lotto, LottoWinningNumber lottoWinningNumber, int matchCount) {
        if (matchCount != 5) {
            return false;
        }
        List<Integer> nums = lotto.getNumbers();
        int bonusNum = lottoWinningNumber.getBonusNum();
        return nums.contains(bonusNum);     //있으면 true 없으면 false return
    }

}
