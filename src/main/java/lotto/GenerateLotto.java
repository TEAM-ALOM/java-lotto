package lotto;

import java.util.ArrayList;
import java.util.List;

//금액 입력받아서 그만큼 로또 생성해서 로또 리스트 리턴
public class GenerateLotto{

    public List<Lotto> generateLotto(int cost){          //입력받은 코스트는 이미 예외처리 후 상태?
        List<Lotto> lottos = new ArrayList<>();
        int count = cost / 1000;


        while (lottos.size() < count){
            GenerateNumber generateLottoNum = new GenerateNumber();
            Lotto newLotto = new Lotto(generateLottoNum.generateLottoNum());
            lottos.add(newLotto);
        }

        return lottos;
    }
}
