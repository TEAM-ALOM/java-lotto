package lotto.view;

import static lotto.validation.ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_DOUBLE_COMMA;
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

    public static List<Integer> winningNumbersInput() {
        String winningNumbers = Console.readLine();
        checkRightCommaFormat(winningNumbers);
        return readNumbersFromConsole(winningNumbers);
    }

    public static int bonusNumberInput() {
        String bonusNumber = Console.readLine();
        return changeInputToInt(bonusNumber);
    }


    private static int changeInputToInt(String moneyForPurchase) {
        checkPossibleChangeToInt(moneyForPurchase);
        return Integer.parseInt(moneyForPurchase);
    }

    private static void checkPossibleChangeToInt(String moneyForPurchase) {
        try {
            Integer.parseInt(moneyForPurchase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
        }
    }

    private static void checkRightCommaFormat(String winningNumbers) {
        if (winningNumbers.startsWith(",")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_START_WITH_COMMA.getMessage());
        }
        if (winningNumbers.endsWith(",")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_END_WITH_COMMA.getMessage());
        }
        if (winningNumbers.contains(",,")) {
            throw new IllegalArgumentException(WINNINGNUMBERS_NOT_DOUBLE_COMMA.getMessage());
        }
    }

    public static List<Integer> readNumbersFromConsole(String winningNumbers) {

        return Arrays.stream(winningNumbers.split(",")).map(InputView::changeInputToInt)
                .collect(Collectors.toList());
    }
}
