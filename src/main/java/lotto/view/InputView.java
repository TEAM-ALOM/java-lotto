package lotto.view;


import lotto.util.BonusNumValidator;
import lotto.util.ExceptionMessage;
import lotto.util.MoneyValidator;
import lotto.util.WinningNumberValidator;
import org.kokodak.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private enum ConsoleMessage{
        INPUT_MONEY("구매금액을 입력해주세요."),
        INPUT_WINNIG_NUMBER("당첨 번호를 입력해주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요");
        private final String message;
        ConsoleMessage(String message){
            this.message=message;
        }
    }

    public int readMoney(){
        System.out.println(ConsoleMessage.INPUT_MONEY.message);
        //String money = Console.readLine();

        String money = org.kokodak.Console.readLine();
        new MoneyValidator().validate(money);
        return Integer.parseInt(money);
    }

    public List<Integer> readWinningNumbers(){
        System.out.println(ConsoleMessage.INPUT_WINNIG_NUMBER.message);
        String input = Console.readLine();
        new WinningNumberValidator().validate(input);
        List<String> winnigNumbersString = new ArrayList<>(List.of(input.split(",")));
        List<Integer> winnigNumbersInteger=new ArrayList<>();
        for (String s : winnigNumbersString) {
            winnigNumbersInteger.add(Integer.parseInt(s));
        }
        return winnigNumbersInteger;
    }

    public int readBonusNumber(List<Integer> winningNums){
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String input = Console.readLine();
        new BonusNumValidator().validate(input);
        int bonusNum=Integer.parseInt(input);
        if (winningNums.contains(bonusNum) == true) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUM.getMessage());
        }
        return bonusNum;
    }
}
