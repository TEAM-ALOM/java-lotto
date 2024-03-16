package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    //돈 입력 -> 돈 입력, 로또 구매 가능 갯수 파악 예외처리(돈 1000이하 or 1000단위 아님)
    //구매 내역 출력 -> 로또 생성기로 개수 만큼 생성
    //당첨번호 입력 -> 6개 숫자 입력 -> 예외처리(1~45 이내, 중복제거)
    //보너스 번호 입력 -> 숫자 입력 -> 예외처리(1~45 이내)
    //당첨 내역 출력
    //수익률 출력
    public void start(){
        try{
            int money = UserInput.getMoney();   //돈 입력
            PurchaseLotto lottoAmount = new PurchaseLotto(money);
            Output.printLottoAmount(lottoAmount.getPurchaseAmount());   //구매 갯수 출력
            Lottos lottos = new Lottos(lottoAmount.generateLottos());   //
            Output.printLottos(lottos);
            List<Integer> winningNumbers = UserInput.getWinningNumbers();
            int bonusNumber = UserInput.getBonusNumber();
            LottoWinningCheck lottoWinningCheck = new LottoWinningCheck();
            Map<Integer, Boolean> lottoResult = lottoWinningCheck.matchingNumbersCount(lottos, winningNumbers, bonusNumber);
            Map<WinningRank, Integer> winningInfo = WinningRank.findWinningCounts(lottoResult);
            Output.printResults(winningInfo);
            double earningRate = Output.calcEarning(winningInfo,money);
            System.out.printf("총 수익률은 %f% 입니다", earningRate);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
