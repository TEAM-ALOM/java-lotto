package lotto.lotto;

import org.kokodak.Randoms;

import java.util.List;

public class LottoAction {

    private Lotto lotto;

    public LottoAction(){

    }
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

    public Lotto makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lotto = new Lotto(numbers);
        return lotto;
    }

    public List<Integer> getLottoNumber() {
        return lotto.getNumbers();
    }
}
