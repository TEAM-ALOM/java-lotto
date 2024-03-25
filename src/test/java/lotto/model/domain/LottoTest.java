package lotto.model.domain;

import static lotto.validation.ErrorMessage.LOTTO_HAS_DUPLICATED_NUMBER;
import static lotto.validation.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.validation.ErrorMessage.LOTTO_SIZE_NOT_SIX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_NOT_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_HAS_DUPLICATED_NUMBER.getMessage());
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    void 로또번호_정상() {
        new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또번호_비정상_갯수_5개_이하_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_NOT_SIX.getMessage());
    }

    @Test
    void 로또번호_비정상_로또수_범위밖_숫자_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }
}
