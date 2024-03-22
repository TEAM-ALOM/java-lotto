package lotto.domain;

import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    public static List<Integer> randomNumbers() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numberList);

        return numberList;
    }
}
