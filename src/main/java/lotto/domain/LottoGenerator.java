package lotto.domain;


import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_QUANTITY = 6;

    private List<Lotto> lottos = new ArrayList<>();
    private int lottoQuantity;



    //구매 가능한 로또 수량
    public LottoGenerator(int money) {
        lottoQuantity = money / 1000;
    }

    //돈을 0원 이하로 받거나 1000원 단위로 받지 않으면 예외 발생
    private void validateMoney(int money) {
        if (isZeroOrNegativeNumber(money) || !isDividedByOneThousand(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로만 받을 수 있습니다.");
        }
    }

    //돈을 0원 이하로 받았는지 확인
    private boolean isZeroOrNegativeNumber(int money) {
        if (money <= 0){
            return true;
        }
        return false;
    }

    //돈을 1000원 단위로 받았는지 확인
    private boolean isDividedByOneThousand(int money) {
        if (money % 1000 == 0) {
            return true;
        }
        return false;
    }

    //1 ~ 45 사이의 6개 숫자를 랜덤으로 뽑아서 로또 발행
    public Lotto generateLotto() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_QUANTITY)
        );
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);

    }

    //
    public List<Lotto> generateLottos() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    //
    public int getLottoQuantity() {
        return lottoQuantity;
    }

}
