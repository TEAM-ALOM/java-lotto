package lotto.view;

import lotto.constant.ViewConst;
import lotto.domain.LottoPurchaseDto;
import lotto.domain.LottoResultDto;

import java.util.List;

public class OutputView {

    public void displayPurchaseResult(LottoPurchaseDto lottoPurchaseDto) {
        System.out.println(lottoPurchaseDto.getCount()+ ViewConst.PURCHASE_RESPONSE.getMessage());
        List<List<Integer>> lottos = lottoPurchaseDto.getLottos();
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void displayWinningResult(LottoResultDto lottoResultDto) {

        System.out.println(ViewConst.WINNING_RESULT.getMessage());
        System.out.println(ViewConst.THREE_WIN.getMessage() + lottoResultDto.getFifthCount()+ "개");
        System.out.println(ViewConst.FOUR_WIN.getMessage() + lottoResultDto.getFourthCount()+ "개");
        System.out.println(ViewConst.FIFTH_WIN.getMessage() + lottoResultDto.getThirdCount()+ "개");
        System.out.println(ViewConst.FIFTH_WIN_WITH_BONUS.getMessage() + lottoResultDto.getSecondCount()+ "개");
        System.out.println(ViewConst.SIXTH_WIN.getMessage() + lottoResultDto.getFirstCount()+ "개");
        System.out.println("총 수익률은 " + String.format("%.1f", lottoResultDto.getRate()) + "%입니다.");
    }
}
