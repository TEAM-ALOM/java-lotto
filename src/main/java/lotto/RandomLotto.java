package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLotto {
    public RandomLotto(){}

    public List<Integer> getRandomlotto(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
