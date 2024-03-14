package lotto;

import lotto.controller.Controller;
import lotto.lotto.EntireLotto;


public class Application {
    static String[] goalNumbers;
    static int bonusNumber;
    static int amount;
    static int buyNumber;
    static EntireLotto entireLotto;
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();

    }


}
