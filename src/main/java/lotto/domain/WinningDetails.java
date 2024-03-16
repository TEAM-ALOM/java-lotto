package lotto.domain;

import java.util.List;

public class WinningDetails {

//    로또 1개와 당첨번호 비교, 일치하는 개수 찾기(스트림 필터)
    private static int compareWithWinningNums(Lotto lotto, LottoWinningNumber lottoWinningNumber) {
        List<Integer> nums = lotto.getNumbers();
        List<Integer> winningNums = lottoWinningNumber.getWinningNums();
        return (int) nums.stream()
                .filter(winningNums::contains)
                .count();
    }

//    5개 일치 시에만 호출하면 되지 않나?
    private static boolean compareWithBonusNum(Lotto lotto, LottoWinningNumber lottoWinningNumber/*, int matchCount*/) {
        List<Integer> nums = lotto.getNumbers();
        int bonusNum = lottoWinningNumber.getBonusNum();
        return nums.contains(bonusNum);     //있으면 true 없으면 false return
    }

}
