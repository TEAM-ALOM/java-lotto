package lotto.domain;

import lotto.util.Validation;
import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 구매한 로또
public class PurchasedLotto {
    public static final int LOTTO_PRICE = 1000;

    private final int lottoCount;
    private final List<Lotto> lottoSet = new ArrayList<>();

    public PurchasedLotto(int purchasedAmount) {
        Validation.validateMoneyRange(purchasedAmount);
        this.lottoCount = purchasedAmount / LOTTO_PRICE;
        generatedLotto();
    }

    // 구매한 로또 생성
    private void generatedLotto() {
        for (int i=0; i<lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoSet.add(new Lotto(numbers));
        }
    }

    // 구매한 로또 개수 반환
    public int getLottoCount() {
        return lottoCount;
    }

    // 구매한 로또 반환
    public List<Lotto> getLottoSet() {
        return lottoSet;
    }

    // 구매 금액 반환
    public int getPurchaseAmount() {
        return lottoCount * LOTTO_PRICE;
    }
}
