package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;
import lotto.lotto.EntireLotto;
import lotto.ui.UI;

public class Program {
    static String[] goalNumbers;
    static int bonusNumber;
    static int amount;
    static int buyNumber;
    static EntireLotto entireLotto;
    static Scanner scanner;
    static UI ui;
    public void requestPrice(){
        ui = new UI();
        scanner = new Scanner(System.in);

        ui.printRequestPrice();
        validatePrice(scanner.nextLine());

    }
    public void makeEntireLotto(){
        buyNumber = amount / 1000;
        ui.printMakeEntireLotto(buyNumber);

        entireLotto = new EntireLotto(buyNumber);
        for (int i = 0; i < buyNumber; i++) {
            entireLotto.makeLotto();
        }
    }
    public void requestWinNumber(){
        System.out.println("당첨 번호를 입력해주세요.");
        goalNumbers=scanner.nextLine().split(",");
    }
    public void requestBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
        bonusNumber=Integer.valueOf(scanner.nextLine());
    }
    public void printResult(){
        entireLotto.makeResult(goalNumbers,bonusNumber);
        entireLotto.printResult(amount);
    }
    public void validatePrice(String amountString){
        try {
            amount = Integer.parseInt(amountString);
        }catch (Exception e){
            System.out.println("[ERROR]");

            throw new IllegalArgumentException();

        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
