package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
  private static final int LOTTO_PRICE = 1000;

  public static Lotto createRandomLotto() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    return new Lotto(numbers);
  }

  public static List<Lotto> purchaseLotto(int purchaseAmount) {
    List<Lotto> lottoSet = new ArrayList<>();
    int lottoCount = purchaseAmount / LOTTO_PRICE;

    for (int i = 0; i < lottoCount; i++) {
      Lotto lotto = createRandomLotto();
      LottoUtils.validateLottoNumbers(lotto.getNumbers());
      lottoSet.add(lotto);
    }
    return lottoSet;
  }

  public static int[] calculateWiningResult(List<Lotto> lottoSet, List<Integer> winningNumbers, int bonusWinningNumber) {
    int[] winingResult = new int[5]; // 3개 일치, 4개 일치, 5개 일치, 5개+보너스, 6개 일치

    int matchCount = 0;
    int bonusCount = 0;

    for (Lotto lotto : lottoSet) {
      for (int lottoNum : lotto.getNumbers()) {
        if (winningNumbers.contains(lottoNum)) {
          matchCount++;
        }
        if (lottoNum == bonusWinningNumber) {
          bonusCount = 1;
        }
      }

      // winingResult 업데이트
      if (matchCount == 3) {
        winingResult[0]++;
      } else if (matchCount == 4) {
        winingResult[1]++;
      } else if (matchCount == 5 && bonusCount == 0) {
        winingResult[2]++;
      } else if (matchCount == 5 && bonusCount == 1) {
        winingResult[3]++;
      } else if (matchCount == 6) {
        winingResult[4]++;
      }
      matchCount = 0;
      bonusCount = 0;
    }

    return winingResult;
  }

  public static int getTotalPrize(int[] winingResult) {
    return winingResult[0] * 5000 +   // 3개 일치
        winingResult[1] * 50000 +     // 4개 일치
        winingResult[2] * 1500000 +   // 5개 일치
        winingResult[3] * 30000000 +  // 5개+보너스
        winingResult[4] * 2000000000; // 6개 일치
  }

}
