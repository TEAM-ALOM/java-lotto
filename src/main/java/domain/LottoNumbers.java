package domain;



import org.kokodak.Randoms;

import java.util.Collections;
import java.util.List;


public class LottoNumbers {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoNumberList;
    public static List<Integer> setRandomLottos(){
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        //해당 범위내 값에서 CNT만큼 증복되지 않는 로또 번호 가져와 리스트 형태로 반환해줌
        Collections.sort(lottoNumberList);//오름차순 정렬 위함
        return lottoNumberList;
    }

}