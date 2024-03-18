package lotto.lotto;

import java.util.List;

public class LottoAction {

    private Lotto lotto;

    public LottoAction(Lotto lotto){
        this.lotto = lotto;
    }

    public int howManySameNumebr(List<Integer> answer){
        int sameNumber=0;
        for (Integer answerNumber: answer){
            sameNumber += lotto.hasNumber(answerNumber);
        }
        return sameNumber;
    }
    public boolean isSameBouns(Integer bonus){
        return lotto.isSameBounusNumber(bonus);
    }


}
