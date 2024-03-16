package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseDto {
    List<List<Integer>> lottos = new ArrayList<>();
    Integer count;

    public LottoPurchaseDto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            this.lottos.add(lotto.getNumbers());
        }
        this.count = lottos.size();
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public void setLottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
