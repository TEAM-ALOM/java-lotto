package lotto.controller;

import java.util.List;
import lotto.model.domain.LottoUser;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottosGenerator;
import lotto.model.service.LottosWinningChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystemController {

    private final LottoUser lottoUser;

    public LottoSystemController(LottoUser lottoUser) {
        this.lottoUser = lottoUser;
    }

    public void runLottoSystem() {
        try {
            buyLottos();

            WinningNumbers winningNumbers = inputWinningNumbers();

            winningResult(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.displayErrorMessage(e.getMessage());
        }
    }

    private void buyLottos() {
        OutputView.moneyForPurchaseInputMessage();
        int userMoney = InputView.moneyForPurchaseInput();

        lottoUser.setMoney(userMoney);

        LottosGenerator.generateLottosAndInput(lottoUser, userMoney);

        OutputView.userLottos(lottoUser.getLottos().getLottoBundle());
    }

    private WinningNumbers inputWinningNumbers() {
        OutputView.winningNumbersInputMessage();
        List<Integer> winningNumbersInput = InputView.winningNumbersInput();

        OutputView.bonusNumberInputMessage();
        int bonusNumberInput = InputView.bonusNumberInput();

        return new WinningNumbers(
                winningNumbersInput, bonusNumberInput
        );
    }

    private void winningResult(WinningNumbers winningNumbers) {
        LottosWinningChecker.generateWinningStatusAndInput(lottoUser, winningNumbers);
        OutputView.winningStatusMessage(lottoUser.getLottosWinningStatus());
    }
}
