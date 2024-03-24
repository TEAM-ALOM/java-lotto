package lotto.model.service;

import static lotto.model.domain.WinningType.MATCHES_FIVE;
import static lotto.model.domain.WinningType.MATCHES_FIVE_WITH_BONUS;
import static lotto.model.domain.WinningType.MATCHES_FOUR;
import static lotto.model.domain.WinningType.MATCHES_SIX;
import static lotto.model.domain.WinningType.MATCHES_THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoUser;
import lotto.model.domain.Lottos;
import lotto.model.domain.LottosWinningStatus;
import lotto.model.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottosWinningCheckerTest {
    private static LottoUser lottoUser;
    private static WinningNumbers winningNumbers;
    private static final int USER_MONEY = 5000;

    @BeforeAll
    static void initData() {
        List<Lotto> inputLottos = new ArrayList<>();
        addLotto(inputLottos, List.of(1, 2, 3, 4, 5, 6));
        addLotto(inputLottos, List.of(10, 11, 12, 13, 14, 15));
        addLotto(inputLottos, List.of(35, 36, 37, 38, 39, 40));
        addLotto(inputLottos, List.of(17, 18, 19, 20, 21, 22));
        addLotto(inputLottos, List.of(30, 31, 32, 33, 34, 35));
        lottoUser = new LottoUser(
                new Lottos(
                        5,
                        inputLottos
                ),
                USER_MONEY
        );
    }

    private static void addLotto(List<Lotto> inputLottos, List<Integer> lottoNumbers) {
        inputLottos.add(
                new Lotto(lottoNumbers)
        );
    }


    /**
     * 각_당첨_타입에_맞는_값_정상누적_확인
     */
    @Test
    void 정상_3개일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(4, 5, 6, 10, 11, 12);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(inputWinningLottoNumbers,
                bonusNumber);

        assertThat(lottosWinningStatus.getMatchesThree()).isEqualTo(2);
    }


    @Test
    void 정상_4개일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(4, 5, 10, 11, 12, 13);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getMatchesFour()).isEqualTo(1);
    }

    @Test
    void 정상_5개일치_보너스_불일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(5, 10, 11, 12, 13, 14);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getMatchesFive()).isEqualTo(1);
    }

    @Test
    void 정상_5개일치_보너스도_일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(5, 10, 11, 12, 13, 14);
        int bonusNumber = 15;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getMatchesFiveWithBonus()).isEqualTo(1);
    }

    @Test
    void 정상_6개일치_일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(10, 11, 12, 13, 14, 15);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getMatchesSix()).isEqualTo(1);
    }

    /**
     * 각타입_수익률_정상계산
     */
    @Test
    void 수익률_정상_3개일치_계산() {
        List<Integer> inputWinningLottoNumbers = List.of(4, 5, 6, 10, 11, 12);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(inputWinningLottoNumbers,
                bonusNumber);

        assertThat(lottosWinningStatus.getProfitRatio()).isEqualTo(
                (double) lottosWinningStatus.getMatchesThree() * MATCHES_THREE.getProfitMoney() / USER_MONEY);
    }

    @Test
    void 수익률_정상_4개일치_계산() {
        List<Integer> inputWinningLottoNumbers = List.of(1, 2, 3, 4, 41, 42);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        System.out.println(lottosWinningStatus.getMatchesThree());
        System.out.println(lottosWinningStatus.getMatchesFour());
        System.out.println(lottosWinningStatus.getMatchesFive());

        assertThat(lottosWinningStatus.getProfitRatio()).isEqualTo(
                (double) lottosWinningStatus.getMatchesFour() * MATCHES_FOUR.getProfitMoney() / USER_MONEY);
    }

    @Test
    void 수익률_정상_5개일치_보너스_불일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(5, 10, 11, 12, 13, 14);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getProfitRatio()).isEqualTo(
                (double) lottosWinningStatus.getMatchesFive() * MATCHES_FIVE.getProfitMoney() / USER_MONEY);
    }

    @Test
    void 수익률_정상_5개일치_보너스도_일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(5, 10, 11, 12, 13, 14);
        int bonusNumber = 15;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getProfitRatio()).isEqualTo(
                (double) lottosWinningStatus.getMatchesFiveWithBonus() *
                        MATCHES_FIVE_WITH_BONUS.getProfitMoney() / USER_MONEY);
    }

    @Test
    void 수익률_정상_6개일치_일치_확인() {
        List<Integer> inputWinningLottoNumbers = List.of(10, 11, 12, 13, 14, 15);
        int bonusNumber = 45;
        LottosWinningStatus lottosWinningStatus = getLottosWinningStatusAfterWinningChecker(
                inputWinningLottoNumbers, bonusNumber);

        assertThat(lottosWinningStatus.getProfitRatio()).isEqualTo(
                (double) lottosWinningStatus.getMatchesSix() * MATCHES_SIX.getProfitMoney() / USER_MONEY);
    }

    private static LottosWinningStatus getLottosWinningStatusAfterWinningChecker(List<Integer> inputWinningLottoNumbers,
                                                                                 int bonusNumber) {
        winningNumbers = new WinningNumbers(
                inputWinningLottoNumbers,
                bonusNumber
        );
        return LottosWinningChecker.generateWinningStatusAndInput(lottoUser,
                winningNumbers);
    }

}