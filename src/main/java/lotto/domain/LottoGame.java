package lotto.domain;

import lotto.domain.betting.Betting;
import lotto.domain.number.Lotto;
import lotto.domain.participant.WinningNumbers;

import java.util.ArrayList;

public class LottoGame {
    private final ArrayList<Lotto> lotto;
    private final WinningNumbers winningNumbers;
    private final Betting betting;


    public LottoGame(final ArrayList<Lotto> lotto, final WinningNumbers winningNumbers,
                     final Betting betting) {
        this.winningNumbers = winningNumbers;
        this.lotto = lotto;
        this.betting = betting;
        initGame();
    }
    private void initGame() {
        for(Lotto c:lotto){
            for(Integer v:c.getNumbers()){
                System.out.print(v+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(Integer v:winningNumbers.getArray()){
            System.out.print(v+" ");
        }
        System.out.println();
        System.out.println(winningNumbers.getBonusNumber());
        System.out.println();
        System.out.println(betting.getAmount());
    }
}
