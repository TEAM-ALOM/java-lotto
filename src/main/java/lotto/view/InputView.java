package lotto.view;

import lotto.Lotto;
import org.kokodak.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String inputMyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return numberList(Console.readLine());
    }

    private static List<Integer> numberList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        ArrayList<Integer> winningNumberList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            winningNumberList.add(Integer.parseInt(numbers[i]));
        }
        return winningNumberList;
    }

    public static int inputBonusNumber(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

}
