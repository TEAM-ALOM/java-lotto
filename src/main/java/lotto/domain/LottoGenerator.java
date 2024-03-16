package lotto.domain;


import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;    //로또 1개 1000원

    private final List<Lotto> lottos = new ArrayList<>();
    private final int lottoQuantity;    //로또 개수(양)

    public LottoGenerator(int money) {
        validateMoney(money);
        lottoQuantity = money/LOTTO_PRICE;
    }

//    금액만큼 로또 생성
    public List<Lotto> generateLottos() {
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

//    구입 로또 개수
    public int getLottoQuantity() {
        return lottoQuantity;
    }



//    금액확인
    private void validateMoney(int money) {
        if (money <= 0 || money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 단위는 1,000원 단위입니다.");
        }
    }

//    로또 1개 생성
    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());    //오름차순
        return new Lotto(numbers);
    }

}
