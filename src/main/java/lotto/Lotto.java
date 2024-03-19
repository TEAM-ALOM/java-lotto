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

    public static void printWinningResults(List<Integer> winningNums, List<Lotto> lottos, int purchaseP) {
        int first, second, third, fourth, fifth;
        double earningRate;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        earningRate = (fifth * 5 + fourth * 50 + third * 1500 + second * 30000 + first * 2000000) / (purchaseP / 1000) * 100;
        System.out.println("총 수익률은 " + earningRate + "입니다.");

    }

    public static int checkWinningResults(List<Integer> winningNums, List<Lotto> lottos, int num){
        int numOfWinnings = 0;
        for(int i = 0; i<lottos.size(); i++){
            for(int j = 0; j < 6; i++){

            }
        }
        return numOfWinnings;
    }

    // TODO: 추가 기능 구현
}
