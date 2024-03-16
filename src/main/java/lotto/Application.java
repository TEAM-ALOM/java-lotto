package lotto;

import lotto.winningLotto.WinningLotto;
import lotto.winningLotto.InputWinPriceNumber;


public class Application {

    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "%d개를 구매했습니다.\n";

    public static void main(String[] args) {

        final int purchaseAmount =  BuyLotto.getPurchaseAmount();
        Lotto[] lotto = new Lotto[purchaseAmount];

        System.out.printf(HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE,purchaseAmount);

        for (int i = 0; i < purchaseAmount; i++) {
            lotto[i] = new Lotto(CreateRandomLottoNumbers.createRandomLottoNumbers());
            lotto[i].printNumbers();
        }

        WinningLotto winningLotto = new WinningLotto(InputWinPriceNumber.getWinPriceNumber(), InputWinPriceNumber.getLottoBonusNumber());


    }
}