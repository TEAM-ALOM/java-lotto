package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.SortLottoNumber.sortNumbers;

public class CreateRandomLottoNumbers {
    public static List<Integer> createRandomLottoNumbers() {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
