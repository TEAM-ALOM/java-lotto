package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoUser;
import lotto.model.domain.Lottos;
import org.kokodak.Randoms;

public class LottosGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;


    public static void generateLottosAndInput(LottoUser lottoUser, int userMoney) {
        int count = userMoney / 1000;

        lottoUser.setLottos(new Lottos(count, generateLottos(count)));
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            userLottos.add(generateLotto());
        }
        return userLottos;
    }

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT));
    }

}
