package lotto.view;

import static lotto.validation.ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_DOUBLE_COMMA;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_END_WITH_COMMA;
import static lotto.validation.ErrorMessage.WINNINGNUMBERS_NOT_START_WITH_COMMA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 구입금액_정상_입력() {
        String input = "1000";
        setInput(input);
        int money = InputView.moneyForPurchaseInput();
        assertThat(input).isEqualTo(String.valueOf(money));
    }

    @Test
    void 구입금액_비정상_입력_문자_예외발생() {
        String input = "english";
        setInput(input);
        assertThatThrownBy(() -> InputView.moneyForPurchaseInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_정상_입력() {
        String input = "1,2,3,4,5,6";
        List<Integer> rightWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        setInput(input);
        assertThat(rightWinningNumbers).isEqualTo(InputView.winningNumbersInput());
    }

    @Test
    void 당첨번호_비정상_입력_문자_예외발생() {
        String input = "1,a,3,4,5,6";
        setInput(input);
        assertThatThrownBy(() -> InputView.winningNumbersInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
    }

//    @Test
//    void 당첨번호_비정상_입력_쉼표누락() {
//        String input = "1,,3,4,5,6";
//        setInput(input);
//        assertThatThrownBy(() -> InputView.winningNumbersInput())
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage(ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
//    }

    @Test
    void 당첨번호_비정상_입력_쉼표중복_예외발생() {
        String input = "1,,3,4,5,6";
        setInput(input);
        assertThatThrownBy(() -> InputView.winningNumbersInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNINGNUMBERS_NOT_DOUBLE_COMMA.getMessage());
    }

    @Test
    void 당첨번호_비정상_입력_처음_또는_끝에_쉼표_예외발생() {
        String input = ",3,4,5,6";
        setInput(input);
        assertThatThrownBy(() -> InputView.winningNumbersInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNINGNUMBERS_NOT_START_WITH_COMMA.getMessage());

        input = "3,4,5,6,";
        setInput(input);
        assertThatThrownBy(() -> InputView.winningNumbersInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNINGNUMBERS_NOT_END_WITH_COMMA.getMessage());
    }

    @Test
    void 보너스번호_정상_입력() {
        String input = "3";
        setInput(input);
        int money = InputView.bonusNumberInput();
        assertThat(input).isEqualTo(String.valueOf(money));
    }

    @Test
    void 보너스번호_비정상_입력_문자_예외발생() {
        String input = "e";
        setInput(input);
        assertThatThrownBy(() -> InputView.bonusNumberInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());

    }

    private static void setInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}