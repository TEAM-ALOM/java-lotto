package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumberTest {
    // 로또 번호 개수는 6개 아니면 실패
    // 로또 번호는 중복되면 안 됨.
    // 로또 번호는 1 ~ 45인 수
    // 보너스 번호는 1 ~ 45인 수
    // 로또 번호와 보너스 번호는 중복 X
    @Test
    @DisplayName("당첨 로또 번호 개수는 6개가 아니면 에러가 발생합니다.")
    void winnerNumberSizeIsNotSix(){
        List<Integer> winnerNumbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> winnerNumbers2 = List.of(1, 2, 3, 4, 8, 10, 12);
        List<Integer> winnerNumbers3 = List.of(1);
        int bonusNumber = 40;

        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
    @Test
    @DisplayName("당첨 로또 번호는 중복되면 에러가 발생합니다.")
    void duplicateWinnerNumbers(){
        List<Integer> winnerNumbers1 = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> winnerNumbers2 = List.of(1, 3, 3, 3, 8, 12);
        List<Integer> winnerNumbers3 = List.of(1, 5, 2, 1, 9);
        int bonusNumber = 40;

        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    @DisplayName("로또 당첨 숫자는 1 ~ 45 사이 숫자가 아닌 경우, 실패")
    void winnnerNumberRangeIsBetweenOneAndFourtyFive() {
        List<Integer> winnerNumbers1 = List.of(-5, 2, 3, 4, 5, 5);
        List<Integer> winnerNumbers2 = List.of(1, -1, 3, 3, 8, 12);
        List<Integer> winnerNumbers3 = List.of(1, 0, 2, 1, 9);
        List<Integer> winnerNumbers4 = List.of(1, 0, 2, 46, 9);
        List<Integer> winnerNumbers5 = List.of(1, 0, 2, 1, 70);
        int bonusNumber = 40;

        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers4, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers5, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {-12,-1, 0, 46, 87})
    @DisplayName("보너스 번호는 1 ~ 45인 숫자가 아니면 실패")
    void bonusNumberRangeIsBetweenOneAndFourtyFive(int bonusNumber){
        List<Integer> winnerNumbers = List.of(1, 2, 5, 6, 10, 45);
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호와 당첨 번호가 중복되면 실패")
    void WinnerNumbersContainBonusNumber(){
        //given
        List<Integer> winnerNumbers = List.of(1, 3, 5, 6, 8, 10);
        int bonusNumber = 5;

        //when
        Assertions.assertThatThrownBy(() -> new LottoWinnerNumber(winnerNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        //then

    }
}