package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    public void setWinningLotto(String numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String number : numbers.split(","))
            lottoNumbers.add(Integer.parseInt(number));
        winningLotto = new Lotto(lottoNumbers);
    }
    public void setBonusNumber(int bonusNumber){
        winningLotto.addBonusNumber(bonusNumber);
    }
}
