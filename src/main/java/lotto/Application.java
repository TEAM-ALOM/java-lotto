package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int count = Output.userBuyOut();

        ArrayList<List<Integer>> numberU = new ArrayList<>();
        numberU = lotto.Lotto.LottoNumber(count);

        Output.usernumber(numberU, count);

        List<Integer> luckyNumber = new ArrayList<>();
        luckyNumber = Output.luckyNumberOut();

        int plusNumber = Output.plusNumberOut();

        int[] win = lotto.Lotto.LottoWinning(numberU, luckyNumber, plusNumber, count);
        Output.luckyResult(win, lotto.Lotto.LottoReturnRate(win, count));

    }
}


