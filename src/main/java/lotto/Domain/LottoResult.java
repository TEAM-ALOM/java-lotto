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

}
