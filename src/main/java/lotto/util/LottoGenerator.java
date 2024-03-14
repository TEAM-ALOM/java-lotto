package lotto.util;

import java.util.List;

import org.kokodak.Randoms;
public class LottoGenerator {

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
