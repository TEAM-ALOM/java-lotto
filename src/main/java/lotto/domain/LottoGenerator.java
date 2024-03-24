package lotto.domain;

import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_NUMBER_LOWER_LIMIT = 1;
    private static final int LOTTO_NUMBER_UPPER_LIMIT = 45;
    private static final int LOTTO_NUMBER_QUANTITY = 6;
    private static final int ZERO = 0;
    private static final String MONEY_SHOULD_BE_DIVIDED_BY_ONE_THOUSAND = "[ERROR] 구입 금액은 1,000원 단위로만 받을 수 있습니다.";
    // static 변수로 생성
    private final List<Lotto> lottos = new ArrayList<>();
    private final int lottoQuantity;

    public LottoGenerator(int money) {
        validateMoney(money);
        lottoQuantity = money / LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(MONEY_SHOULD_BE_DIVIDED_BY_ONE_THOUSAND);
        }
    }

    private boolean isZeroOrNegativeNumber(int money) {
        return money <= ZERO;
    }

    private boolean isDividedByOneThousand(int money) {
        return money % LOTTO_PRICE == ZERO;
    }

    public List<Lotto> generateLottos() { // 로또들을 담을 객체 반환
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT, LOTTO_NUMBER_QUANTITY);
        // 범위 내에서 로또 번호 생성
        randomNumbers.sort(Comparator.naturalOrder()); // 오름차순 정렬
        return new Lotto(randomNumbers); // 생성한 로또 반환
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
