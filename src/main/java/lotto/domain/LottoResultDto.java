package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
    // 등수, 당첨 로또의 개수
    private Map<Integer, Integer> result = new HashMap<>();

    public LottoResultDto() {
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public void setResult(Map<Integer, Integer> result) {
        this.result = result;
    }
}
