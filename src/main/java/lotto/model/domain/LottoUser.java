package lotto.model.domain;

public class LottoUser {
    private Lottos lottos;
    private final int money;
    private LottosWinningStatus lottosWinningStatus;


    public LottoUser(int money) {
        this.money = money;
    }

    public LottoUser(Lottos lottos, int money) {
        this.lottos = lottos;
        this.money = money;
    }

    public LottoUser(Lottos lottos, int money, LottosWinningStatus lottosWinningStatus) {
        this.lottos = lottos;
        validationMoney(money);
        this.money = money;
        this.lottosWinningStatus = lottosWinningStatus;
    }

    private void validationMoney(int money) {
        checkMoneyOutOfRange(money);
        checkMoneyDivisibility(money);
    }

    private void checkMoneyDivisibility(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMoneyOutOfRange(int money) {
        if (money < 0 || money > 100000) {
            throw new IllegalArgumentException();
        }
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
}
