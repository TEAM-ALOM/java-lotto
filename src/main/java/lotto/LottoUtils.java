package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoUtils {
  public static void validateLottoNumbers(List<Integer> numbers) {
    // 개수 검증
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또번호는 6개여야 합니다.");
    }

    // 중복 숫자 검증
    Set<Integer> setNumbers = new HashSet<>(numbers);
    if( setNumbers.size() != numbers.size()){
      throw new IllegalArgumentException("[ERROR] 로또번호는 중복될 수 없습니다.");
    }
  }

  public static void verifyLottoNumber(int lottoNum) {
    if (!(1 <= lottoNum && lottoNum <= 45)) {
      throw new IllegalArgumentException("[ERROR] 로또번호는 1부터 45사이의 숫자여야합니다.");
    }
  }

  public static void verifyLottoNumbers(List<Integer> winingNumbers) {
    for (int lottoNum : winingNumbers) {
      verifyLottoNumber(lottoNum);
    }
  }

  public static int verifyPurchaseAmount(String purchaseAmountString) {
    try {
      int purchaseAmount = Integer.parseInt(purchaseAmountString);

      if (purchaseAmount % 1000 != 0 || purchaseAmount < 0) {
        throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
      }

      return purchaseAmount;

    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
    }
  }
}
