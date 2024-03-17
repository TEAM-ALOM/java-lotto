package lotto.View;

import org.kokodak.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INVALID_VALUE = "[ERROR] 올바른 값을 입력하세요.";

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
    }

//    찾아볼필요 ㅇ
    public static List<Integer> getWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }

    }

    public static int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
    }
}
