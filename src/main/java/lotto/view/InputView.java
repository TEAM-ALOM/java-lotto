package lotto.view;

import org.kokodak.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputMyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            ExceptionMessage.isNotNumber();
            throw new IllegalArgumentException();
        }

    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return numberList(Console.readLine());
    }

    private static List<Integer> numberList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        ArrayList<Integer> winningNumberList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            try {
                winningNumberList.add(Integer.parseInt(numbers[i]));
            } catch (NumberFormatException e){
                ExceptionMessage.isNotNumber();
                throw new IllegalArgumentException();
            }
        }
        return winningNumberList;
    }

    public static int inputBonusNumber(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            ExceptionMessage.isNotNumber();
            throw new IllegalArgumentException();
        }
    }

}