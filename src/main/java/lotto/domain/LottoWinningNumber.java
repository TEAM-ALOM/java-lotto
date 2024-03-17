package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {

    private final List<Integer> winningNums;
    private final int bonusNum;


    public LottoWinningNumber(List<Integer> winningNums, int bonusNum) {
//        에러 체크
        validateDuplicateNum(winningNums, bonusNum);
        isBetween1and45(winningNums, bonusNum);

        this.winningNums = winningNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    //    중복 번호 체크
    private void validateDuplicateNum(List<Integer> winningNum, int bonusNum) {
        Set<Integer> duplicateCheck = new HashSet<>(winningNum);
        if (winningNum.size() != duplicateCheck.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 6개의 숫자여야 합니다.");
        }
        if (winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

//    1~45 사이의 번호
    private void isBetween1and45(List<Integer> winningNums, int bonusNum) {
        for (int num : winningNums) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


}
