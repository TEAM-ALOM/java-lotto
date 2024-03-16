package lotto;

import java.util.List;

//로또 여러장 구매 -> 여러개의 로또들 List로
public class Lottos {
    private List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
