package lotto.controller;

import lotto.domain.CreateRandomLottoNumbers;
import lotto.domain.InputPurchaseAmount;
import lotto.domain.Lotto;
import lotto.domain.InputWinPriceNumber;
import lotto.domain.WinningLotto;

public class LottoController {
    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "%d개를 구매했습니다.\n";
    public void lottoStart(){
        final int purchaseAmount =  InputPurchaseAmount.getPurchaseAmount();
        Lotto[] lotto = new Lotto[purchaseAmount];

        System.out.printf(HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE,purchaseAmount);

        for (int i = 0; i < purchaseAmount; i++) {
            lotto[i] = new Lotto(CreateRandomLottoNumbers.createRandomLottoNumbers());
            lotto[i].printNumbers();
        }

        WinningLotto winningLotto = new WinningLotto(InputWinPriceNumber.getWinPriceNumber(), InputWinPriceNumber.getLottoBonusNumber());

    }
}
