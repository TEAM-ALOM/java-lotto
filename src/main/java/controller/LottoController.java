package controller;

import lotto.GenerateLotto;
import lotto.Lottos;
import view.InputView;
import view.OutputView;

public class LottoController {
    public void startLotto() {
        try {
            int cost = InputView.buyLotto();
            GenerateLotto generateLotto = new GenerateLotto(cost);
            Lottos lottos = new Lottos(generateLotto.generateLottos());

            OutputView.printHowManyLottoUserPurchased(generateLotto.getCount());
            OutputView.printLottos(lottos);


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
