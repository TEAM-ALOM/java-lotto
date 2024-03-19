package lotto;

import org.kokodak.Randoms;

import java.util.random.*;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNum(){
        return numbers;
    }

    //구매한 로또 개수 구하기
    public static int getNumberOfLotto(int price){
        if(price % Lotto.LOTTO_PRICE == 0)
            return price / Lotto.LOTTO_PRICE;

        throw new IllegalArgumentException("[ERROR]구입금액이 정수개로 나누어 떨어지지 않습니다!");
    }
    //로또 개수만큼 로또 생성하기
    public static void generateLotto(List<Lotto> lottoList, int num){
        for(int i = 0; i<num; i++){
            List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numberList);
            Lotto lotto = new Lotto(numberList);
            lottoList.add(lotto);
        }
    }

    public static boolean isWinningNumberValuable(List<Integer> numbers){
        for(int i = 0; i<numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                return false;
            }
        }
        return true;
    }


    public static int checkWinningResults(List<Integer> winningNums, Lotto lottos, int bonusN){
        int numOfWinnings = 0;
        for (int number : lottos.numbers) {
             if (winningNums.contains(number)) numOfWinnings++;
         }
        if(numOfWinnings == 0 || numOfWinnings == 1 || numOfWinnings == 2) return 0;
        if(numOfWinnings == 3) return 5;
        if(numOfWinnings == 4) return 4;
        if(numOfWinnings == 5){
            if (lottos.numbers.contains(bonusN))
                return 2;
            return 3;
        }
        return 1;
    }
}
