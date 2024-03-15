package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoGenerator;
import domain.LottoRepository;
import domain.WinningLotto;
import lotto.Lotto;
import view.UserInput;
import view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static Lotto MakeLottoNum() {
        List<Integer> lottoNumbers = new ArrayList<>();

        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return LottoGenerator.generateLotto(lottoNumbers);
    }
    public static void printAlllottos(LottoRepository lottoRepository) {
        for (Lotto lotto : lottoRepository.getAllLotto()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public static void run() throws IOException {
        LottoRepository lottoRepository = new LottoRepository();
        UserInput.input();
        View.output();
        LottoService.printAlllottos(lottoRepository);
    }
}
