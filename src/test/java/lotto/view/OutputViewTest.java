package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.model.domain.LottosWinningStatus;
import lotto.validation.ErrorMessage;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void 당첨통계_정상_출력_갯수_0이상_정상() {
        OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, 1, 1, 300.1222
                )
        );
    }

    @Test
    void 당첨통계_정상_출력_갯수_음수면_예외발생() {
        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        -1, 1, 1, 1, 1, 300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, -1, 1, 1, 1, 300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, -1, 1, 1, 300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, -1, 1, 300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, 1, -1, 300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

        assertThatThrownBy(() -> OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, 1, 1, -300.1222
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUTPUT_VIEW_WINNING_STATUS_NUMBER_MINUS.getMessage());

    }

    @Test
    void 수익률_반올림_정상_확인() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, 1, 1, 300.1222
                )
        );

        String printedOutput = outputStream.toString().trim();

        System.setOut(originalOut);

        assertThat(printedOutput).contains("300.1%");
    }

    @Test
    void 수익률_반올림_정상_확인2() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        OutputView.winningStatusMessage(
                new LottosWinningStatus(
                        1, 1, 1, 1, 1, 300.1722
                )
        );

        String printedOutput = outputStream.toString().trim();

        System.setOut(originalOut);

        assertThat(printedOutput).contains("300.2%");
    }


}