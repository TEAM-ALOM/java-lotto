package lotto;

import lotto.controller.LottoSystemController;
import lotto.model.domain.LottoUser;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoSystemController lottoSystemController = new LottoSystemController(new LottoUser());
        lottoSystemController.runLottoSystem();
    }
}