package lotto.model.domain;

import static lotto.validation.ErrorMessage.BONUS_NUMBER_IS_DUPLICATED;
import static lotto.validation.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTO_HAS_DUPLICATED_NUMBER;
import static lotto.validation.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTO_SIZE_NOT_SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    private static final List<Integer> RIGHT_WINNINGNUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void winningLotto_로또번호_개수_6개가_아니면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_NOT_SIX.getMessage());

        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_NOT_SIX.getMessage());
    }

    @Test
    void winningLotto_로또번호_중복숫자_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_HAS_DUPLICATED_NUMBER.getMessage());
    }

    @Test
    void winningLotto_로또번호_범위밖_숫자_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());

        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 0), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());

        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, -1), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    void bonusNumber_winningLotto와_중복_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(RIGHT_WINNINGNUMBERS, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_IS_DUPLICATED.getMessage());
    }

    @Test
    void bonusNumber_로또번호_범위밖_숫자_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(RIGHT_WINNINGNUMBERS, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OUT_OF_RANGE.getMessage());

        assertThatThrownBy(() -> new WinningNumbers(RIGHT_WINNINGNUMBERS, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OUT_OF_RANGE.getMessage());

        assertThatThrownBy(() -> new WinningNumbers(RIGHT_WINNINGNUMBERS, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    void winningLotto_bonusNumber_모두정상() {
        int rightBonusNumber = 10;
        WinningNumbers winningNumbers = new WinningNumbers(RIGHT_WINNINGNUMBERS, rightBonusNumber);

        assertThat(winningNumbers.getWinningLotto().getNumbers()).isEqualTo(RIGHT_WINNINGNUMBERS);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(rightBonusNumber);
    }

    @Test
    void winningLotto_검증우선_bonusNumber_후순위() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46), -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

}