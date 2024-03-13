package lotto.domain.number;

import org.kokodak.Randoms;

import java.util.List;
import java.util.Collections;

public class LottoMachine {

    public static Lotto createNumbers() {
        final List<Integer> list = Randoms.
                pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(list);

        return new Lotto(list);
    }
}
