package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
import lotto.domain.WinningLotto;
import lotto.validator.InputValidator;

public class InputView {

    public static PurchaseLotto inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = InputValidator.validateInputNumber(input);
        return new PurchaseLotto(price);
    }

    private static int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validateNumber(input);
    }

    private static Lotto inputLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validateInputLottoNumber(input);
    }

    public static WinningLotto inputWinningLotto(){
        System.out.println();
        Lotto lotto = inputLotto();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

}
