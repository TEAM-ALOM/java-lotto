package lotto.lotto;


import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.List;

public class EntireLotto {
    private final List<LottoAction> lottos;
    private List<Integer> answerList;
    private int[] result;

    private int number;


    public EntireLotto(int number) {
        lottos = new ArrayList<>(6);
        this.number = number;

    }

    public void makeLottos() {
        LottoAction la = new LottoAction();
        lottos.add(new LottoAction(la.makeLotto()));
        //어캐 나눠야지 안정성있고, 좋은 코드가 될까
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
        for (LottoAction la : lottos) {
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
    public void printEntireLottoNumbers(){
        for (LottoAction lottoAction : lottos) {
            System.out.println(lottoAction.getLottoNumber());

        }

    }

}
