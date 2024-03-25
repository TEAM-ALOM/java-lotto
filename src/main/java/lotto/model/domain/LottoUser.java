package lotto.model.domain;

import lotto.validation.Validation;

public class LottoUser {
    private Lottos lottos;
    private int money;
    private LottosWinningStatus lottosWinningStatus;

    public LottoUser() {

    }

    public LottoUser(int money) {
        this.money = money;
    }

    public LottoUser(Lottos lottos, int money) {
        this.lottos = lottos;
        this.money = money;
    }

    public LottoUser(Lottos lottos, int money, LottosWinningStatus lottosWinningStatus) {
        this.lottos = lottos;
        Validation.validationMoney(money);
        this.money = money;
        this.lottosWinningStatus = lottosWinningStatus;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    public LottosWinningStatus getLottosWinningStatus() {
        return lottosWinningStatus;
    }

    public void setLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public void setLottosWinningStatus(LottosWinningStatus lottosWinningStatus) {
        this.lottosWinningStatus = lottosWinningStatus;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
