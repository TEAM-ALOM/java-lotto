package lotto.view;

import static lotto.validation.ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_END_WITH_COMMA;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_START_WITH_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.kokodak.Console;

public class InputView {
    public static int moneyForPurchaseInput() {
        String moneyForPurchase = Console.readLine();
        return changeInputToInt(moneyForPurchase);
    }

    private static int changeInputToInt(String moneyForPurchase) {
        checkPossibleChangeToInt(moneyForPurchase);
        return Integer.parseInt(moneyForPurchase);
    }

    private static void checkPossibleChangeToInt(String moneyForPurchase) {
        try {
            Integer.parseInt(moneyForPurchase);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
        }
    }

    private static void checkNotExistStartAndEndComma(String winningNumbers) {
        if (winningNumbers.startsWith(",")) {
            throw new IllegalStateException(WINNINGNUMBERS_NOT_START_WITH_COMMA.getMessage());
        }
        if (winningNumbers.endsWith(",")) {
            throw new IllegalStateException(WINNINGNUMBERS_NOT_END_WITH_COMMA.getMessage());
        }
    }

    public static List<Integer> winningNumbersInput() {
        String winningNumbers = Console.readLine();
        checkNotExistStartAndEndComma(winningNumbers);
        return readNumbersFromConsole(winningNumbers);
    }

    public static List<Integer> readNumbersFromConsole(String winningNumbers) {

        return Arrays.stream(winningNumbers.split(",")).map(InputView::changeInputToInt)
                .collect(Collectors.toList());
    }
}
