package lotto.view;

import static lotto.view.ViewMessage.BONUS_NUMBER_PROMPT;
import static lotto.view.ViewMessage.LOTTOS_SIZE_PROMPT;
import static lotto.view.ViewMessage.MAIN_WINNING_NUMBERS_PROMPT;
import static lotto.view.ViewMessage.PURCHASE_AMOUNT_PROMPT;
import static lotto.view.ViewMessage.WINNING_STATUS_MAIN;
import static lotto.view.ViewMessage.WINNING_STATUS_START;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottosWinningStatus;
import lotto.validation.Validation;

public class OutputView {

    public static void moneyForPurchaseInputMessage() {
        System.out.println(PURCHASE_AMOUNT_PROMPT.getMessage());
    }

    public static void userLottos(List<Lotto> userLottos) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.printf(LOTTOS_SIZE_PROMPT.getMessage(), userLottos.size());
        for (Lotto userLotto : userLottos) {
            stringBuilder.append(userLotto.getNumbers().toString()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void winningNumbersInputMessage() {
        System.out.println(MAIN_WINNING_NUMBERS_PROMPT.getMessage());
    }

    public static void bonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_PROMPT.getMessage());
    }

    public static void winningStatusMessage(LottosWinningStatus lottosWinningStatus) {
        validationWinningStatusNumber(lottosWinningStatus);
        System.out.println(WINNING_STATUS_START.getMessage());
        System.out.printf(WINNING_STATUS_MAIN.getMessage(),
                lottosWinningStatus.getMatchesThree(),
                lottosWinningStatus.getMatchesFour(),
                lottosWinningStatus.getMatchesFive(),
                lottosWinningStatus.getMatchesFiveWithBonus(),
                lottosWinningStatus.getMatchesSix(),
                lottosWinningStatus.getProfitRatio());
    }

    public static void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static void validationWinningStatusNumber(LottosWinningStatus lottosWinningStatus) {
        Validation.checkStatusValueMinus(lottosWinningStatus.getMatchesThree());
        Validation.checkStatusValueMinus(lottosWinningStatus.getMatchesFour());
        Validation.checkStatusValueMinus(lottosWinningStatus.getMatchesFive());
        Validation.checkStatusValueMinus(lottosWinningStatus.getMatchesFiveWithBonus());
        Validation.checkStatusValueMinus(lottosWinningStatus.getMatchesSix());
        Validation.checkStatusValueMinus(roundToTwoDigits(lottosWinningStatus.getProfitRatio()));
    }

    private static double roundToTwoDigits(double profitRatio) {
        return profitRatio + 0.05;
    }
}