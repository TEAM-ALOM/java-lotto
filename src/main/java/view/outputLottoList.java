package view;

import lotto.Lottos;

public class outputLottoList {
    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
