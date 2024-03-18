package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final List<Lotto> lottos = new ArrayList<>();
    public final int lottoQuantity;

    public LottoGenerator(int money){
        validateMoney(money);
        lottoQuantity = money / 1000;
    }

    private void validateMoney(int money){
        if (isZeroOrNegativeNumber(money) || !isDividedByOneThousand(money)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean isZeroOrNegativeNumber(int money) {
        return money <= 0;
    }

    private boolean isDividedByOneThousand(int money) {
        return money % 1000 == 0;
    }

    public List<Integer> generateLottos(){
        return new Random()
                .ints(1, 45 + 1)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }
}
