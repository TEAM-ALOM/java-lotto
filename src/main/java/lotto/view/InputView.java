package lotto.view;


import org.kokodak.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NOT_NUMBER = "[ERROR] 숫자가 아닌 값이 입력됐습니다.";

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public static List<Integer> getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public static int getLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
