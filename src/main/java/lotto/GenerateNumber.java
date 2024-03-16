package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GenerateNumber {
    public List<Integer> generateLottoNum(){
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNum.sort(Comparator.naturalOrder());
        return lottoNum;
    }
}
