package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복되지 않는 보너스 숫자를 입력해주세요.");
        }
    }

    public ResultLotto matchLotto(Lotto purchaseLotto){
        int count = purchaseLotto.matchLotto(winningLotto);
        boolean isBonus = purchaseLotto.contains(bonusNumber);

        if (count != 5) {
            isBonus = false;
        }

        return ResultLotto.valueOf(count, isBonus);
    }



}
