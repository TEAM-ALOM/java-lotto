package lotto.domain;

import lotto.util.Validation;
import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto {
    public static final int LOTTO_PRICE = 1000;

    private final int lottoCount;
    private final List<Lotto> lottoSet = new ArrayList<>();

    public PurchasedLotto(String purchasedAmount) {
        int money = Validation.validateMoney(purchasedAmount);
        this.lottoCount = money / LOTTO_PRICE;
        generatedLotto();
    }

    private void generatedLotto() {
        for (int i=0; i<lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoSet.add(new Lotto(numbers));
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottoSet() {
        return lottoSet;
    }

    public int getPurchaseAmount() {
        return lottoCount * LOTTO_PRICE;
    }
}
