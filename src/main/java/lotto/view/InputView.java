package lotto.view;

import lotto.util.Validation;
import org.kokodak.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR_VALUE = ",";

    // 구매 금액 입력
    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Validation.parseInteger(Console.readLine());
    }

    // 당첨 번호 입력
    public static List<Integer> getLottoNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Arrays.stream(Console.readLine().split(SEPARATOR_VALUE))
                .map(Validation::parseInteger)
                .collect(Collectors.toList());
    }

    // 보너스 번호 입력
    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Validation.parseInteger(Console.readLine());
    }
}
