package Controller;

import domain.*;
import view.Input;
import view.Output;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void lottoStart(){
        try {
            int purchaseAmount = Input.inputPurchaseAmount(); // 금액 입력
            LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount); // 로또 발행기에 금액 설정
            lottoGenerator.createLottos(); // 로또 발행하기
            Lottos lottos = new Lottos(lottoGenerator.getLottos());
            Output.outputLottosNumbers(lottos); // 뽑은 로또 모든 번호 출력

            List<Integer> winnerNumbers = Input.inputWinnerNumbers();//
            int bonusNumber = Input.inputBonusNumber();
            LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerNumbers, bonusNumber);

            Map<WinningRank, Integer> winningDetails = LottoStatics.getWinningDetails(lottos, lottoWinnerNumber);


            Output.outputWinnerStatics(winningDetails, purchaseAmount);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
