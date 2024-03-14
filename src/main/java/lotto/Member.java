package lotto;

import org.kokodak.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Member {
    private int purchaseAmount;
    private int countLotto;
    private int myReturn;
    private double returnRate;
    private List<Lotto> myLotto = new ArrayList<>();

    public enum Result{
        THREE(3), FOUR(4), FIVE(5), FIVE_WITH_BONUS(5), SIX(6);

        Result(int i) {
        }
    }

    public Member() {
    }

    private void validate(int purchaseAmount){
        if(purchaseAmount < 1000)
            throw new IllegalArgumentException("[ERROR] 구입 금액이 올바르지 않습니다.");
    }
    public void setPurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void setCountLotto(){
        this.countLotto = purchaseAmount/1000;
    }
    public void getCountLotto() {
        System.out.println(countLotto + "개를 구매하셨습니다.");
    }
    private void setReturnRate(double returnRate) {
        this.returnRate = returnRate;
    }

    public void getMyLotto() {
        myLotto.forEach(Lotto::printLotto);
    }

    public void setMyLotto() {
        myLotto = IntStream.range(0, countLotto)
                .mapToObj(i -> {
                    List<Integer> numbers =
                            Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Collections.sort(numbers);
                    return new Lotto(numbers);
                })
                .collect(Collectors.toList());
    }
}
