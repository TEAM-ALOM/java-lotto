package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
    // 등수, 당첨 로또의 개수
    private Map<Integer, Integer> result = new HashMap<>();
    private Double rate;

    public LottoResultDto() {
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public Double getRate() {
        return rate;
    }

    public void setResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public Integer getFirstCount() {
        return result.get(1);
    }

    public Integer getSecondCount() {
        return result.get(2);
    }

    public Integer getThirdCount() {
        return result.get(3);
    }
    public Integer getFourthCount() {
        return result.get(4);
    }
    public Integer getFifthCount() {
        return result.get(5);
    }

}
