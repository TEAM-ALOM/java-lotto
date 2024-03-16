package lotto;

import lotto.winningLotto.WinningLotto;
import lotto.winningLotto.InputWinPriceNumber;


public class Application {

    public static void main(String[] args) {

        final int purchaseAmount =  BuyLotto.getPurchaseAmount();
        Lotto[] lotto = new Lotto[purchaseAmount];

        System.out.println(purchaseAmount + "개 구매했습니다.");

        for (int i = 0; i < purchaseAmount; i++) {
            lotto[i] = new Lotto(CreateRandomLottoNumbers.createRandomLottoNumbers());
            lotto[i].printNumbers();
        }

        WinningLotto winningLotto = new WinningLotto(InputWinPriceNumber.getWinPriceNumber(), InputWinPriceNumber.getLottoBonusNumber());


    }
}