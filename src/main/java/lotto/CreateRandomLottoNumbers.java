package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CreateRandomLottoNumbers {
    public static List<Integer> createRandomLottoNumbers() {
        return SortLottoNumber.sortNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
