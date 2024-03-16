package lotto.view;

import lotto.util.ValidationFilter;
import org.kokodak.Console;
public class InputView {

    public Integer readMoney() {
        System.out.println(ViewConst.MONEY_REQUEST.getMessage());
        String money = Console.readLine();
        ValidationFilter.isNumber(money);
        return Integer.parseInt(money);
    }
}
