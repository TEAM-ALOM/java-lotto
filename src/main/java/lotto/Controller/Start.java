package lotto.Controller;

import lotto.View.InOut;
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
        RandomLotto randomLotto = new RandomLotto();

        int LottoAmount =inOut.InLottoMoney()/1000; //로또 개수 확인

        List<List> myRandomLottoList = randomLotto.setRandomLottoList(LottoAmount); //LottoAmount 개의 랜덤 로또 번호 생성


        inOut.OutLottoAmount(LottoAmount); //로또 개수 출력
        inOut.OutLottoList(myRandomLottoList); //랜덤으로 생성된 로또 출력

        List<Integer> WinningLotto = inOut.InWinningLotto(); //로또 당첨 번호 입력
        int BonusNum = inOut.InBonusNum(); //보너스 번호 입력

        for(List<Integer> LottoList : myRandomLottoList){ //로또 당첨 결과 설정
            int Count = lottoResult.getResult(LottoList,WinningLotto);
            setResult(Count,WinningLotto,BonusNum); }

        double RateOfReturn = lottoResult.getRateOfReturn(getResultMoney(),LottoAmount*1000); //수익률

        inOut.OutResultStatistics(FIRST,SECOND,THIRD,FORTH,FIVTH,RateOfReturn); //결과 출력




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

    private double getResultMoney(){
        return FIRST*2000000000 + SECOND*30000000 + THIRD*1500000 + FORTH*50000 + FIVTH*5000;
    }



}
