package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {
    public RandomLotto(){}

    public List<Integer> getRandomlotto(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public static List<Integer> setRandomLotto(){ //단일 로또 생성
        RandomLotto randomLotto = new RandomLotto();
        Lotto lotto = new Lotto(randomLotto.getRandomlotto());
        return lotto.getLotto();
    }

    public static List<List> setRandomLottoList(Integer Amount){ //Amount개의 로또 생성
        List<List> RandomLottoList = new ArrayList<>();
        for(int i=0;i<Amount;i++){
            RandomLottoList.add(setRandomLotto());
            Collections.sort(RandomLottoList.get(i));
        }
        return RandomLottoList;
    }
}
