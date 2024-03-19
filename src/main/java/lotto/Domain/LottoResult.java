package lotto.Domain;

import java.util.List;

public class LottoResult {
    public LottoResult(){}

    public long getLottoResult(List<Integer> LottoList,List<Integer> WinningLotto){
        return LottoList.stream()
                .filter(WinningLotto::contains)
                .count();

    }
    public Boolean getBounsResult(Integer BounNum,List<Integer> WinningLotto){
        return WinningLotto.contains(BounNum);
    }

    public double getRateOfReturn(double ResultMoney,double LottoMoney){ //수익률 계산
        double a = (ResultMoney/LottoMoney)*100;
        return Math.round(a*10.0)/10.0;
    }

    public Integer getResult(List<Integer> LottoList,List<Integer> WinningLotto){ //개별 로또의 결과 확인
        LottoResult lottoResult = new LottoResult();
        return (int)lottoResult.getLottoResult(LottoList,WinningLotto);
    }

}
