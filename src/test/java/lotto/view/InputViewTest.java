package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.validation.ErrorMessage;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 구입금액_정상_입력() {
        String input = "1000";
        setInput(input);
        int money = InputView.moneyForPurchaseInput();
        assertThat(input).isEqualTo(String.valueOf(money));
    }

    private static void setInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 구입금액_비정상_입력_문자() {
        String input = "english";
        setInput(input);
        assertThatThrownBy(() -> InputView.moneyForPurchaseInput())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.MONEY_FOR_PURCHASE_NOT_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_정상_입력() {
        
    }

    @Test
    void 당첨번호_비정상_입력_문자() {

    }

    @Test
    void 당첨번호_비정상_입력_쉼표누락() {

    }

    @Test
    void 당첨번호_비정상_입력_쉼표중복() {

    }

    @Test
    void 당첨번호_비정상_입력_처음_또는_끝에_쉼표() {

    }

    @Test
    void 보너스번호_정상_입력() {

    }

    @Test
    void 보너스번호_비정상_입력_문자() {

    }

}