package lotto.view;

import lotto.constant.ViewConst;
import lotto.util.ValidationFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

    public Integer readMoney() {
        System.out.println(ViewConst.MONEY_REQUEST.getMessage());
        String money = readLine();
        return ValidationFilter.isNumber(money);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(ViewConst.WINNING_NUMBER_REQUEST.getMessage());
        String numbers = readLine();
        String[] split = numbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : split) {
            Integer num = ValidationFilter.isNumber(s);
            ValidationFilter.isInRange(num);
            winningNumbers.add(num);
        }
        ValidationFilter.isSixNumbers(winningNumbers);
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        System.out.println(ViewConst.BONUS_NUMBER_REQUEST.getMessage());
        String number = readLine();
        Integer bonusNumber = ValidationFilter.isNumber(number);
        ValidationFilter.isInRange(bonusNumber);
        return bonusNumber;
    }
}
