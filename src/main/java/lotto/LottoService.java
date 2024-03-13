package lotto;

import java.util.ArrayList;
import java.util.List;
import org.kokodak.Randoms;

// service
public class LottoService {
  private static final int LOTTO_PRICE = 1000;

  // 랜덤 번호 생성 -> Lotto 객체 생성
  public static Lotto createRandomLotto() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    return new Lotto(numbers);
  }

  // 개수만큼 로또 생성
  public static List<Lotto> purchaseLotto(int purchaseAmount) {
    List<Lotto> lottoList = new ArrayList<>();
    int lottoCount = purchaseAmount / LOTTO_PRICE;

    for (int i = 0; i < lottoCount; i++) {
      Lotto lotto = createRandomLotto();
      LottoUtils.verifyLottoNumbers(lotto.getNumbers());
      lottoList.add(lotto);
    }
    return lottoList;
  }

  // 당첨결과 계산 -> 반환
  public static int[] calculateWiningResult(List<Lotto> lottoSet, List<Integer> winningNumbers, int bonusWinningNumber) {
    int[] winingResult = new int[5]; // 3개 일치, 4개 일치, 5개 일치, 5개+보너스, 6개 일치

    int matchCount = 0;
    int bonusCount = 0;

    // 당첨 결과 계산
    for (Lotto lotto : lottoSet) {
      for (int lottoNum : lotto.getNumbers()) {
        if (winningNumbers.contains(lottoNum)) {
          matchCount++;
        }
        if (lottoNum == bonusWinningNumber) {
          bonusCount = 1;
        }
      }

      // 당첨결과 업데이트
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

  // 전체 당첨금 계산
  public static int getTotalPrize(int[] winingResult) {
    return winingResult[0] * 5000 +   // 3개 일치
        winingResult[1] * 50000 +     // 4개 일치
        winingResult[2] * 1500000 +   // 5개 일치
        winingResult[3] * 30000000 +  // 5개+보너스
        winingResult[4] * 2000000000; // 6개 일치
  }

}
