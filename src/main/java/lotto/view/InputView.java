package lotto.view;

import lotto.dto.BuyAmountDto;
import lotto.dto.LottoDto;
import org.kokodak.Console;

import java.util.List;

public enum InputView {
    INSTANCE;
    private static final String Input_Winning_Numbers_Message = "당첨 번호를 입력하세요";
    private static final String Input_Bonus_Number_Message = "보너스 번호를 입력하세요";
    private static final String Input_Buy_Amount_Message = "구입 금액을 입력하세요";

    public BuyAmountDto inputBuyAmount(){
        System.out.println(Input_Buy_Amount_Message);
        String buyAmount = Console.readLine();
        return new BuyAmountDto(InputValidator.validateBuyAmount(buyAmount));
    }

    public LottoDto inputLottoNumbers(){
        List<Integer> winningNumbers = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumber(winningNumbers);
        return new LottoDto(winningNumbers, bonusNumber);
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println(Input_Winning_Numbers_Message);
        String winningNumbers = Console.readLine();
        return InputValidator.validateWinningNumbers(winningNumbers);
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers){
        System.out.println(Input_Bonus_Number_Message);
        String bonusNumber = Console.readLine();
        return InputValidator.validateBonusNumber(winningNumbers, bonusNumber);
    }
}
