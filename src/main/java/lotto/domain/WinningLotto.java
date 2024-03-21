package lotto.domain;

import org.kokodak.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;
    public void setWinningLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        for(String number : numbers.split(","))
            lottoNumbers.add(Integer.parseInt(number));
        winningLotto = new Lotto(lottoNumbers);
    }

    public void setBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        this.bonusNumber = winningLotto.addBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
