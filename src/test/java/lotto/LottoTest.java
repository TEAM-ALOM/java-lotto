package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;

import lotto.domain.betting.Betting;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoArray;
import lotto.domain.number.LottoMachine;
import lotto.domain.number.WinningNumbers;
import lotto.domain.result.EarningsRate;
import lotto.domain.result.MatchedPlace;
import lotto.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {123, 100, 1001, 1203123})
    void AmountIsNotDividedBy1_000(int amount) {
        assertThatThrownBy(() -> new LottoMachine(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }@DisplayName("구입 금액이 0 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000", "-123123"})
    void AmountIsLessThan0(String amount) {
        assertThatThrownBy(() -> new Betting(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 일치 개수와 보너스 번호 일치 여부를 통해서 당첨 등수를 구한다.")
    void findWinningRankTest() {
        MatchedPlace winningRank1 = MatchedPlace.findPlace(0, false);
        MatchedPlace winningRank2 = MatchedPlace.findPlace(1, false);
        MatchedPlace winningRank3 = MatchedPlace.findPlace(2, false);
        MatchedPlace winningRank4 = MatchedPlace.findPlace(3, false);
        MatchedPlace winningRank5 = MatchedPlace.findPlace(4, false);
        MatchedPlace winningRank6 = MatchedPlace.findPlace(5, false);
        MatchedPlace winningRank7 = MatchedPlace.findPlace(5, true);
        MatchedPlace winningRank8 = MatchedPlace.findPlace(6, false);

        assertThat(winningRank1).isEqualTo(MatchedPlace.ELSE);
        assertThat(winningRank2).isEqualTo(MatchedPlace.ELSE);
        assertThat(winningRank3).isEqualTo(MatchedPlace.ELSE);
        assertThat(winningRank4).isEqualTo(MatchedPlace.FIFTH);
        assertThat(winningRank5).isEqualTo(MatchedPlace.FOURTH);
        assertThat(winningRank6).isEqualTo(MatchedPlace.THIRD);
        assertThat(winningRank7).isEqualTo(MatchedPlace.SECOND);
        assertThat(winningRank8).isEqualTo(MatchedPlace.FIRST);
    }

    @Test
    @DisplayName("각 등수마다 몇 개씩 당첨되었는지 계산 -> 1등 1개, 2등 2개, 5등 2개, 꽝 1개")
    void getMatchedDetailsTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lotto lotto4 = new Lotto(List.of(40, 2, 3, 43, 44, 6));
        Lotto lotto5 = new Lotto(List.of(40, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(40, 1, 2, 3, 4, 5));
        LottoArray lottoArray = new LottoArray(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), "40");
        Map<MatchedPlace, Integer> winningDetails = Result.getMatchedDetails(lottoArray, winningNumbers);

        assertThat(winningDetails.get(MatchedPlace.ELSE)).isEqualTo(1);
        assertThat(winningDetails.get(MatchedPlace.FIFTH)).isEqualTo(2);
        assertThat(winningDetails.get(MatchedPlace.SECOND)).isEqualTo(2);
        assertThat(winningDetails.get(MatchedPlace.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 내역을 이용해 당첨 금액을 구한다.")
    void getEarningsTest() {
        Map<MatchedPlace, Integer> winningDetails = Result.generateMatchedDetails();
        winningDetails.replace(MatchedPlace.SECOND, 2);
        winningDetails.replace(MatchedPlace.FOURTH, 5);
        winningDetails.replace(MatchedPlace.FIFTH, 13);

        long winningAmount = EarningsRate.getEarning(winningDetails);
        assertThat(winningAmount).isEqualTo(60_315_000);
    }

    @Test
    @DisplayName("당첨 내역을 이용해 수익률을 구한다.")
    void getEarningsRateTest() {
        double earningsRate;
        earningsRate = EarningsRate.getEarningsRate(130_290_000, 45000);
        assertThat(earningsRate).isEqualTo(289533.3);

        earningsRate = EarningsRate.getEarningsRate(123300, 523000);
        assertThat(earningsRate).isEqualTo(23.6);
    }
}