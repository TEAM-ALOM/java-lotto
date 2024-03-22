package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    public final int count;
    public final List<Lotto> lottos = new ArrayList<>();

    public LottoNumber(int money) {
        moneyValidate(money);
        this.count = money / 1000;
    }

    private void moneyValidate(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalStateException("error");
        }
    }

    public void createLotto() {
        for (int i = 0; i < count ; i++) {
            Lotto lotto = createLottoNumber();
            lottos.add(lotto);
        }
    }

    public Lotto createLottoNumber() {
        List<Integer> integers = Numbers.randomNumbers();
        return new Lotto(integers);
    }
}
