package lotto.Controller;

import lotto.Domain.InOut;
import lotto.Domain.Lotto;
import lotto.Domain.LottoResult;
import lotto.Domain.RandomLotto;

import java.util.*;

public class Start {
    public Start(){}

    public int FIRST = 0; //6개 - 2,000,000,000
    public int SECOND = 0; //5개 + 보너스 - 50,000,000
    public int THIRD = 0; //5개 - 1,500,000
    public int FORTH = 0; //4개 - 50,000
    public int FIVTH = 0; //3개 - 5,000


    public void run(){
        InOut inOut = new InOut();
        LottoResult lottoResult = new LottoResult();

        int LottoAmount =inOut.InLottoMoney()/1000; //로또 개수 확인

        List<List> myRandomLottoList = new ArrayList<>();
        myRandomLottoList = setRandomLottoList(LottoAmount); //LottoAmount 개의 랜덤 로또 번호 생성

        System.out.println(LottoAmount+"개를 구매하셨습니다");

        for(List<Integer> LottoList : myRandomLottoList){ //랜덤으로 생성된 로또 출력
            System.out.println(LottoList);  }


        List<Integer> WinningLotto = inOut.InWinningLotto(); //로또 당첨 번호 입력
        int BonusNum = inOut.InBonusNum(); //보너스 번호 입력

        for(List<Integer> LottoList : myRandomLottoList){ //로또 당첨 결과 설정
            int Count = getResult(LottoList,WinningLotto);
            setResult(Count,WinningLotto,BonusNum); }

        ResultStatistics(LottoAmount); //결과 출력




    }

    private static List<Integer> setRandomLotto(){ //단일 로또 생성
        RandomLotto randomLotto = new RandomLotto();
        Lotto lotto = new Lotto(randomLotto.getRandomlotto());
        return lotto.getLotto();
    }
    public static List<List> setRandomLottoList(Integer Amount){ //Amount개의 로또 생성
        List<List> RandomLottoList = new ArrayList<>();
        for(int i=0;i<Amount;i++){
            RandomLottoList.add(setRandomLotto());
            Collections.sort(RandomLottoList.get(i));
        }
        return RandomLottoList;
    }

    private Integer getResult(List<Integer> LottoList,List<Integer> WinningLotto){ //개별 로또의 결과 확인
        LottoResult lottoResult = new LottoResult();
        return (int)lottoResult.getLottoResult(LottoList,WinningLotto);
    }

    private void setResult(Integer Count,List<Integer> WinningLotto , Integer BonusNum){ //등수에 해당하는 로또 개수 업데이트
        LottoResult lottoResult = new LottoResult();
        switch (Count){
            case 3:
                FIVTH++;
                break;
            case 4:
                FORTH++;
                break;
            case 5:
                if(lottoResult.getBounsResult(BonusNum,WinningLotto) == Boolean.TRUE){
                    //System.out.println("보너스 o");
                    SECOND++;
                    break;
                }
                else if(lottoResult.getBounsResult(BonusNum,WinningLotto) == Boolean.FALSE) {
                    //System.out.println("보너스 x");
                    THIRD++;
                    break;
                }
            case 6:
                FIRST++;
                break;
        }
    }

    private double getRateOfReturn(double ResultMoney,double LottoMoney){ //수익률 계산
        double a = (ResultMoney/LottoMoney);
        return Math.round(a*10.0)/10.0;
    }


    private void ResultStatistics(int LottoAmount){ //로또 최종 통계 출력
        int ResultMoney = FIRST*2000000000 + SECOND*30000000 + THIRD*1500000 + FORTH*50000 + FIVTH*5000;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+FIVTH+"개");
        System.out.println("4개 일치 (50,000원) - "+FORTH+"개");
        System.out.println("5개 일치 (1,500,000원) - "+THIRD+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원) - "+SECOND+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+FIRST+"개");
        System.out.println("총 수익률은 "+getRateOfReturn(ResultMoney,LottoAmount*1000)+"% 입니다");
    }
}
