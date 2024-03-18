package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseLotto {

    private final List<Lotto> lottos;

    public PurchaseLotto(int price) {
        this.lottos = createLotto(price);
    }

    private List<Lotto> createLotto(int price){
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < price/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            // 문제 요건에 맞게 여러 검사와 처리를 해주고(Lotto 클래스) 로또 리스트에 저장
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    private Map<ResultLotto, Integer> createResult() {
        Map<ResultLotto, Integer> results = new HashMap<>();

        for (ResultLotto resultLotto : ResultLotto.values()) {
            results.put(resultLotto, 0);
        }

        return results;
    }

    public Map<ResultLotto, Integer> matchWinningLotto(WinningLotto winningLotto) {
        Map<ResultLotto, Integer> results = createResult();

        for (Lotto purchaseLotto: lottos) {
            ResultLotto resultLotto = winningLotto.matchLotto(purchaseLotto);
            results.put(resultLotto, results.get(resultLotto) + 1);
        }

        return results;
    }

    public List<String> getlottosMessage() {
        List<String> lottoMessage = new ArrayList<>();

        for (Lotto lotto: lottos) {
            lottoMessage.add(lotto.toString());
        }

        return lottoMessage;
    }

    public float calculateProfit(Map<ResultLotto, Integer> result) {
        float totalReward = 0.0f;

        for (ResultLotto resultLotto: ResultLotto.values()) {
            totalReward += resultLotto.getWinningAmount(result.get(resultLotto));
        }

        return totalReward / getPrice() * 100;
    }

    public int getPrice() {
        return lottos.size() * 1000;
    }
}
