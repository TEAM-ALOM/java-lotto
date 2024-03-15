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
        scanner = new Scanner(System.in);           //Console.readline()을 이용해서 코드를 작성하려고 했으나, "unable to determine if the scanner is closed."가 자꾸 출력되어서
        ui.printRequestPrice();                    //테스트 코드에서 오류가 남. 그래서 readLine->scanner로 대체함.
        validatePrice(scanner.nextLine());         //Console이 close되지 않아서 생기는 오류같은데 어떻게 해결해야 할 지 감이 안 잡힘.

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
        ui.printRequestWinNumber();
        goalNumbers=scanner.nextLine().split(",");
    }
    public void requestBonusNumber(){
        ui.printRequestBonusNumber();
        bonusNumber=Integer.valueOf(scanner.nextLine());
    }
    public void printResult(){
        entireLotto.makeResult(goalNumbers,bonusNumber);
        ui.printResult( entireLotto.getResult(),amount);
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
