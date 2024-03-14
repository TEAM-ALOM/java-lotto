package lotto.view;

import lotto.domain.number.Lotto;

import java.util.List;

import static java.text.MessageFormat.format;

public class OutputView {
    public void printLotto(final List<Lotto> lotto) {
        System.out.println();
        System.out.println(lotto.size()+"개를 구매했습니다.");
        for(Lotto c:lotto){
            System.out.println(c.getNumbers());
        }
    }
}
