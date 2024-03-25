package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.Validation;
import org.kokodak.Console;

public class InputView {
    public static int moneyForPurchaseInput() {
        String moneyForPurchase = Console.readLine();
        return changeInputToInt(moneyForPurchase);
    }

    public static List<Integer> winningNumbersInput() {
        String winningNumbers = Console.readLine();
        Validation.checkRightCommaFormat(winningNumbers);
        return readNumbersFromConsole(winningNumbers);
    }

    public static int bonusNumberInput() {
        String bonusNumber = Console.readLine();
        return changeInputToInt(bonusNumber);
    }


    private static int changeInputToInt(String moneyForPurchase) {
        Validation.checkPossibleChangeToInt(moneyForPurchase);
        return Integer.parseInt(moneyForPurchase);
    }

    public static List<Integer> readNumbersFromConsole(String winningNumbers) {

        return Arrays.stream(winningNumbers.split(",")).map(InputView::changeInputToInt)
                .collect(Collectors.toList());
    }
}
