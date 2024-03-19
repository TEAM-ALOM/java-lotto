package lotto.domain;

import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto {
    public static final int LOTTO_PRICE = 1000;

    private final int lottoCount;
    private final List<Lotto> lottoSet = new ArrayList<>();

    public PurchasedLotto(int purchasedAmount) {
        this.lottoCount = purchasedAmount / LOTTO_PRICE;
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
}
