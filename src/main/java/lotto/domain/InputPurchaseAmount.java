package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputPurchaseAmount {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String str = Console.readLine();
        return Integer.parseInt(str) / 1000;
    }
}
