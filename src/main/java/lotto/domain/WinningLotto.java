package lotto.domain;

import lotto.util.Validation;

import java.util.List;

// 당첨 번호
public class WinningLotto {
    private final Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumber) {
        Validation.validateLotto(winningNumber);
        this.winningNumber = new Lotto(winningNumber);
    }

    // 당첨 번호 반환
    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    // 보너스 번호 반환
    public int getBonusNumber() {
        return bonusNumber;
    }

    // 보너스 번호 설정
    public void setBonusNumber(int bonusNumber) {
        Validation.validateBonus(winningNumber.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
