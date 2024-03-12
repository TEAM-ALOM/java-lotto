package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// controller
public class Application {
    public static void main(String[] args) {

        // 구입금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();
        int purchaseAmount = LottoUtils.verifyPurchaseAmount(purchaseAmountString);

        // 구입한 로또 구매
        List<Lotto> lottoSet = LottoService.purchaseLotto(purchaseAmount);

        // 당첨번호 받기
        System.out.println("당첨번호를 입력해 주세요.");
        String winningNumbersString = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(winningNumbersString.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        LottoUtils.verifyLottoNumbers(winningNumbers);

        // 보너스 번호 받기
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusWinningNumber = Integer.parseInt(Console.readLine());
        LottoUtils.verifyLottoNumber(bonusWinningNumber);

        // 당첨 계산
        int[] winningResult = LottoService.calculateWiningResult(lottoSet, winningNumbers, bonusWinningNumber);

        // 로또 정보 출력
        System.out.printf("%d개를 구매했습니다.\n", lottoSet.size());
        for (Lotto lotto : lottoSet) {
            lotto.printLotto();
        }

        // 당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult[4] + "개");

        // 수익률 계산
        int totalPrize = LottoService.getTotalPrize(winningResult);
        double profitability = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitability);
    }
}
