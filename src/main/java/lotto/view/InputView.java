package lotto.view;

import org.kokodak.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Scanner scanner = new Scanner(System.in);

    public String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public List<Integer> readWinningArray() {
        System.out.println("당첨 번호를 입력해 주세요.");
        final String input = Console.readLine();

        return Parser.parseByDelimiter(input,",");
    }
    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
