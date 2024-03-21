package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {
    public LottoNumbers(){

    }
    private static final int cntLottoNumber = 6;
    private static final int minLottoNumber = 1;
    private static final int maxLottoNumber = 45;
    private static List<Integer> lottoNumberList;
    public static List<Integer> setRandomNumbers(){
        lottoNumberList = Randoms.pickUniqueNumbersInRange(minLottoNumber,maxLottoNumber,cntLottoNumber);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }
}