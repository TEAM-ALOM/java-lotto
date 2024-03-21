package lotto.domain;

import lotto.config.BaseException;
import lotto.config.BaseResponseStatus;
import org.kokodak.Console;
import org.kokodak.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Member {
    private int purchaseAmount;
    private int countLotto;
    private List<Lotto> myLotto = new ArrayList<>();
    private MyLottoResult result;
    private double returnRate;


    public Member() {
    }

    private void validate(int purchaseAmount){
        if(purchaseAmount < 1000)
            throw new BaseException(BaseResponseStatus.INCORRECT_PURCHASE_AMOUNT);
    }
    public void setPurchaseAmount() {
        System.out.println("구입 금액 : ");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void setCountLotto(){
        this.countLotto = purchaseAmount/1000;
    }
    public void getCountLotto() {
        System.out.println(countLotto + "개를 구매하셨습니다.");
    }

    public void printMyLotto() {
        myLotto.forEach(Lotto::printLotto);
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
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

    public MyLottoResult getResult(WinningLotto lotto) {
        result.calculateResult(this.myLotto, lotto);
        result.getLottoResult();
        setReturnRate(result.getTotalPrice());
        return result;
    }

    public void setResult(MyLottoResult result) {
        this.result = result;
    }

    public void setReturnRate(int totalPrice) {
        this.returnRate =  ((double) totalPrice / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
