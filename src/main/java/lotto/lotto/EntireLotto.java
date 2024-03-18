package lotto.lotto;


import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.List;

public class EntireLotto {
    private final List<Lotto> lottos;
    private int number;
    private Lotto lotto;
    private List<Integer> answerList;
    private int[] result;


    public EntireLotto(int number) {
        lottos = new ArrayList<>();
        this.number = number;
    }

    public void makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lotto = new Lotto(numbers);
        addLotto(lotto);
        System.out.println(numbers);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public boolean isSize(int size) {
        //System.out.println("size = " + size);
        if (size == lottos.size()) {
            return true;
        }
        return false;
    }//테스트용

    public void makeResult(String[] strings, Integer bonus) {
        result = new int[]{0, 0, 0, 0,0};
        convertToInteger(strings);
        for (Lotto l : lottos) {
            LottoAction la = new LottoAction(l);
            classifyResult(la.howManySameNumebr(answerList),la.isSameBouns(bonus));
        }

    }
    public void earnMoney(int sameNumber,boolean isSameBonus){
        if(isSameBonus==true & sameNumber==5){
            result[3] += 1;
            return;
        }
        if(sameNumber==6){
            result[4] += 1;
            return;
        }
        result[sameNumber - 3] += 1;
        return;
    }
    public void noEarnMoney(){

    }
    public void classifyResult(int sameNumber,boolean isSameBonus){
       if(sameNumber>=3){
           earnMoney(sameNumber,isSameBonus);
       }
    }

    public void convertToInteger(String[] strings) {
        answerList = new ArrayList<>();
        for (String str : strings) {
            answerList.add(Integer.parseInt(str));
        }
    }
    public int[] getResult(){
        return result;
    }

}
