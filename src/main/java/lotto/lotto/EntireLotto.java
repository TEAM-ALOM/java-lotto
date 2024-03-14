package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
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
            classifyResult(l.howManySameNumebr(answerList),l.isSameBouns(bonus));
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
    public void printResult(int amount){
        int sum;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[4]+"개");
        sum = result[0] * 5000 + result[1] * 50000 + result[2] * 1500000 + result[3] * 30000000 +
                result[4] * 2000000000;
        System.out.println("총 수익률은 "+(double)sum/amount*100+"%입니다.");
    }

}
