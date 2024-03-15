package view;

import domain.LottoRepository;
import lotto.Lotto;

public class View {
    public static void output() {
        System.out.println(UserInput.getCountBuyLotto() + "개를 구매했습니다.");
        Lotto.MakeLotto();
    }

    public static void printAllLottos(LottoRepository lottoRepository) {
        for (Lotto lotto : lottoRepository.getAllLotto()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public void printResult() {

    }
}
