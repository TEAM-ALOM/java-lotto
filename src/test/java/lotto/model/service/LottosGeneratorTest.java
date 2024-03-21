package lotto.model.service;

import lotto.model.domain.LottoUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {

    private static LottoUser lottoUser;
    private static LottosGenerator lottosGenerator;

    @BeforeAll
    static void setLottoUser() {
        lottoUser = new LottoUser(3000);
        lottosGenerator = new LottosGenerator(lottoUser);
    }

    @Test
    void Lottos_정상_생성후_유저에_삽입() {
        lottosGenerator.generateLottosAndInput();
        Assertions.assertThat(lottoUser.getLottos().getLottos().size())
                .isEqualTo(lottoUser.getMoney() / 1000);
    }
}