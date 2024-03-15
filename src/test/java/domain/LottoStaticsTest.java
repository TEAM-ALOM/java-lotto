package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoStaticsTest {
    // 로또 등수 별 개수 구하기
    // 총 로또 당첨 금액
    // 로또 수익률 반환
    @Test
    @DisplayName("각 등수마다 당첨 개수 계산 -> 1등 1개, 2등 1개, 3등 1개, 5등 1개 ,나머지 3개")
    void getWinningDetails(){
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6)); // 2개 
        Lotto lotto2 = new Lotto(List.of(1,10,52,36,22,18)); // 3개
        Lotto lotto3 = new Lotto(List.of(5,9,17,23,44,39)); // 1개
        Lotto lotto4 = new Lotto(List.of(44,45,2,30,27, 36)); // 1개
        Lotto lotto5 = new Lotto(List.of(1,5,10,17,18, 7)); // 5개
        Lotto lotto6 = new Lotto(List.of(1,5,10,17,18, 36)); // 5개 + 보너스
        Lotto lotto7 = new Lotto(List.of(1,5,10,17,18, 25)); // 6개
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(List.of(1, 5, 10, 17, 18, 25), 7);

        //when
        Map<WinningRank, Integer> winningDetails = LottoStatics.getWinningDetails(lottos, lottoWinnerNumber);

        //then
        Assertions.assertThat(winningDetails.get(WinningRank.LAST_PLACE)).isEqualTo(3);  // 0 ~ 2 개
        Assertions.assertThat(winningDetails.get(WinningRank.FIFTH_PLACE)).isEqualTo(1); //3개
        Assertions.assertThat(winningDetails.get(WinningRank.THIRD_PLACE)).isEqualTo(1); // 5개
        Assertions.assertThat(winningDetails.get(WinningRank.SECOND_PLACE)).isEqualTo(1); // 5개 + 보너스
        Assertions.assertThat(winningDetails.get(WinningRank.FIRST_PLACE)).isEqualTo(1); // 6개
    }

}