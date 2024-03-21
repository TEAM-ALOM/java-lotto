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
    
    //로또 넘버 반환하는 메소드
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
            List<Integer> numberList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numberList);
            Lotto lotto = new Lotto(numberList);
            lottoList.add(lotto);
        }
    }

    //입력받은 당첨번호의 범위 확인하기
    public static boolean checkWinningNumbersCount(List<Integer> numbers){
        return numbers.size() == 6;
    }

    public static boolean checkWinningNumbersRange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinningNumbersDuplication(List<Integer> numbers){
       Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size())
            return false;
        return true;
    }

    public static void checkWinningNumberBonus(List<Integer> numbers, int bonus){
        Set<Integer> s = new HashSet<>(numbers);
        List<Integer> list = new ArrayList<>(numbers);
        s.add(bonus);
        list.add(bonus);
        if(s.size() != list.size()){
            throw new IllegalArgumentException("[ERROR]로또 번호에 중복이 있습니다.");
        }
    }


    //로또 번호 비교하는 메소드
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
