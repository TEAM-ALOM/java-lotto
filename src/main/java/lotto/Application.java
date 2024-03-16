package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;

import static java.lang.Integer.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }

}
