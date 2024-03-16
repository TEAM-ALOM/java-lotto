package lotto;

import java.util.ArrayList;
import java.util.List;

//금액 입력받아서 그만큼 로또 생성해서 로또 리스트 리턴
public class GenerateLotto {
    int count;

    public GenerateLotto(int cost) {
        validateMoney(cost);
        this.count = cost / 1000;
    }

    public List<Lotto> generateLotto() {          //입력받은 코스트는 이미 예외처리 후 상태?
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < count) {
            GenerateNumber generateLottoNum = new GenerateNumber();
            Lotto newLotto = new Lotto(generateLottoNum.generateLottoNum());
            lottos.add(newLotto);
        }

        return lottos;
    }

    private void validateMoney(int cost){
        if(cost < 0 || cost % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로만 받을 수 있습니다.");
        }
    }
}
