package lotto.view;

import org.kokodak.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
