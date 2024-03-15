package domain;

import lotto.Lotto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoRepository {
    private static final List<Lotto> lottos = new ArrayList<>(); // 모든 로또번호
    public static void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(lottos);
    }
}
