package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningRankTest {
    @Test
    @DisplayName("당첨 로또 번호 일치 개수와 보너스 번호 일치 여부를 통해 당첨 등수를 구한다. ")
    void findWinningRank(){
        WinningRank winningRank = WinningRank.findWinningRank(0, false);
        WinningRank winningRank1 = WinningRank.findWinningRank(1, false);
        WinningRank winningRank2 = WinningRank.findWinningRank(2, false);
        WinningRank winningRank3 = WinningRank.findWinningRank(3, false);
        WinningRank winningRank4 = WinningRank.findWinningRank(4, false);
        WinningRank winningRank5 = WinningRank.findWinningRank(5, false);
        WinningRank winningRank6 = WinningRank.findWinningRank(5, true);
        WinningRank winningRank7 = WinningRank.findWinningRank(6, false);

        Assertions.assertThat(winningRank).isEqualTo(WinningRank.LAST_PLACE);
        Assertions.assertThat(winningRank1).isEqualTo(WinningRank.LAST_PLACE);
        Assertions.assertThat(winningRank2).isEqualTo(WinningRank.LAST_PLACE);
        Assertions.assertThat(winningRank3).isEqualTo(WinningRank.FIFTH_PLACE);
        Assertions.assertThat(winningRank4).isEqualTo(WinningRank.FOURTH_PLACE);
        Assertions.assertThat(winningRank5).isEqualTo(WinningRank.THIRD_PLACE);
        Assertions.assertThat(winningRank6).isEqualTo(WinningRank.SECOND_PLACE);
        Assertions.assertThat(winningRank7).isEqualTo(WinningRank.FIRST_PLACE);

    }

}