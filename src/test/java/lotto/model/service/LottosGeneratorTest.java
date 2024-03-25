package lotto.model.service;

import lotto.model.domain.LottoUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {

    private static LottoUser lottoUser;
    private static final int USER_MONEY = 3000;

    @BeforeAll
    static void setLottoUser() {
        lottoUser = new LottoUser(USER_MONEY);
    }

    @Test
    void Lottos_정상_생성후_유저에_삽입() {
        LottosGenerator.generateLottosAndInput(lottoUser, USER_MONEY);
        Assertions.assertThat(lottoUser.getLottos().getLottoBundle().size())
                .isEqualTo(lottoUser.getMoney() / 1000);
    }
}