package lotto.domain;

import org.kokodak.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public LottoNumbers(){
    }
    private static final int CNT_LOTTO_NUMBER=6;
    private static final int MIN_LOTTO_NUMBER=1;
    private static final int MAX_LOTTO_NUMBER =45;

    private static List<Integer> lotooNumberList;

    public static List<Integer> setRandomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

}
