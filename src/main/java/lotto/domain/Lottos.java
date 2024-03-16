package lotto.domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }
}