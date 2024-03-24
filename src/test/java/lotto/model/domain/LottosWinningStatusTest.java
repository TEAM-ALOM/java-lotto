package lotto.model.domain;

import static lotto.validation.ErrorMessage.WINNING_STATUS_PROFIT_RATIO_OVER_MAX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottosWinningStatusTest {

    private static final double MAX_PROFIT_RATIO_PLUS_ONE =
            (double) (WinningType.MATCHES_SIX.getProfitMoney() + 1) / 1000;

    @Test
    void 최대수익률의_초과수익률이면_예외발생() {
        assertThatThrownBy(() -> new LottosWinningStatus(
                1, 1, 1, 1, 1, MAX_PROFIT_RATIO_PLUS_ONE
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_STATUS_PROFIT_RATIO_OVER_MAX.getMessage());
    }
}