package lotto;

import lotto.domain.Lotto;

import java.util.*;

public class LottoUtils {

    public List<Integer> create(){
        Random random = new Random();
        Set<Integer> lotto =  new HashSet<>();

        while (lotto.size()<6){
            int randomNum = random.nextInt(45)+1;
            lotto.add(randomNum);
        }
        return new ArrayList<>(lotto);
    }

    public void printResult(int[] result,int money){
        int sum=0;
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
               System.out.println("3개 일치 (5,000원) - "+result[3]+"개");
                System.out.println("4개 일치 (50,000원) - "+result[4]+"개");
                System.out.println("5개 일치 (1,500,000원) - "+result[5]+"개");
                System.out.println("6개 일치 (2,000,000,000원) - "+result[6]+"개");
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[7]+"개");

        returnRate(money,sum);
        System.out.println(result);
        System.out.println(sum);
    }

    private void returnRate(int money,int sum) {
        double returnRat=(double) sum/(double) money;
        System.out.println("총 수익률은 "+ returnRat +"%입니다.");
    }


    public int[] compareNum(int money, List<Integer> winningNumberInteger, int bonusNum,LottoUtils generator) {

        int[] result = {0,0,0,0,0,0,0,0};
        System.out.println(money/1000+"개를 구매했습니다.");
        while (money >=1000) {
            Lotto lotto = new Lotto(generator.create());
            money -=1000;


        }
        return result;
    }
}
