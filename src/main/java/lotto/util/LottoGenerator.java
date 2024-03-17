package lotto.util;

import lotto.domain.Lotto;
import lotto.view.OutputView;
import org.kokodak.Randoms;

import java.util.*;

import static lotto.util.Constants.*;

public class LottoGenerator {
    public List<Lotto> generate(int money){
        int ticketNum=money/1000;

        OutputView.printTicketCount(ticketNum);
        List<Lotto> lottos=new ArrayList<>();
        for (int i=0; ticketNum>i; i++){
            List<Integer> lottoNum= new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUM,MAX_NUM,NUM_COUNT));
            Lotto lotto = new Lotto(lottoNum);
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());

        }
        return lottos;
    }
}
