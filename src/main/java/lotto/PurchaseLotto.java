package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PurchaseLotto {    //다른 코드 참고
    private int purchaseAmount; //로또 갯수
    private final List<Lotto> lottos = new ArrayList<>();    //구매한 로또 번호들

    public PurchaseLotto(int money){
        validateMoney(money);
        purchaseAmount = money / 1000;
    }
    private void validateMoney(int money) {     //액수 검증
        money = Integer.parseInt(Console.readLine());
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private Lotto generateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);    //겹치지 않는 숫자 반환

        numbers.sort(Comparator.naturalOrder());

        return new Lotto(numbers);      //이렇게 해야 숫자 체크도 됨
    }
    private List<Lotto> generateLottos(){
        for(int i = 0 ; i < purchaseAmount ; i++){
            Lotto lotto = generateNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }
}
