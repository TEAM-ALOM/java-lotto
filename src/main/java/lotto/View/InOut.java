package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InOut {
    public InOut(){}

    public List<Integer> InWinningLotto(){

        System.out.println("당첨 번호를 입력해 주세요 ");
        String[] input = Console.readLine().split(",");
        List<Integer> WinningLotto = new ArrayList<>();
        for(int i=0;i<6;i++){
            WinningLotto.add(Integer.parseInt(input[i]));
        }

        return new Lotto(WinningLotto).getLotto();
    }
    public Integer InLottoMoney(){
        System.out.println("구입 금액을 입력해 주세요 ");
        return Integer.parseInt(Console.readLine());
    }
    public Integer InBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }

    public void OutResultStatistics(int FIRST,int SECOND,int THIRD,int FORTH,int FIVTH,double RateOfReturn){ //로또 최종 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+FIVTH+"개");
        System.out.println("4개 일치 (50,000원) - "+FORTH+"개");
        System.out.println("5개 일치 (1,500,000원) - "+THIRD+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - "+SECOND+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+FIRST+"개");
        System.out.println("총 수익률은 "+RateOfReturn+"% 입니다");
    }

    public void OutLottoList(List<List> MyRandomLottoList){ //랜덤으로 생성된 로또 출력
        for(List<Integer> myList : MyRandomLottoList){
            System.out.println(myList);
        }
    }

    public void OutLottoAmount(int LottoAmount){
        System.out.println(LottoAmount+"개를 구매하셨습니다");
    }

}
