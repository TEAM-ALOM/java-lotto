package lotto;

import java.util.List;

public class Lottos {   //Lotto 클래스를 List로 묶은 클래스

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
