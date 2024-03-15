package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class Output {

    public static void outputLottoQuantity(LottoGenerator lottoGenerator){
        int lottoQuantity = lottoGenerator.getLottoQuantity();
        String str = "개를 구매했습니다.";
        System.out.println(lottoQuantity + str);

    }
    public static void outputLottosNumbers(Lottos lottos){
        List<Lotto> lottoList = lottos.getLottos();
        String result = "";
        for(Lotto lotto : lottoList){
            List<Integer> numbers = lotto.getNumbers();
            result += "[";
            result = getLottoNumbers(result, numbers);
            result += "]\n";
        }
        System.out.println(result);
    }

    private static String getLottoNumbers(String result, List<Integer> numbers) {
        for(int i = 0; i< numbers.size(); i++){
            result += numbers.get(i);
            if(i == numbers.size() - 1){
                break;
            }
            result += ", ";

        }
        return result;
    }

    public static void outputWinnerStatics(Map<WinningRank, Integer> winningDetails, int purchaseAmount){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(WinningRank.FIFTH_PLACE.getMatchingCount() + "개 일치 (5,000원) - " + winningDetails.get(WinningRank.FIFTH_PLACE));
        System.out.println(WinningRank.FOURTH_PLACE.getMatchingCount() + "개 일치 (50,000원) - " + winningDetails.get(WinningRank.FOURTH_PLACE));
        System.out.println(WinningRank.THIRD_PLACE.getMatchingCount() + "개 일치 (1,500,000원) - " + winningDetails.get(WinningRank.THIRD_PLACE));
        System.out.println(WinningRank.SECOND_PLACE.getMatchingCount() + "개 일치 (30,000,000원) - " + winningDetails.get(WinningRank.SECOND_PLACE));
        System.out.println(WinningRank.FIRST_PLACE.getMatchingCount() + "개 일치 (2,000,000,000원) - " + winningDetails.get(WinningRank.FIRST_PLACE));
        System.out.println("총 수익률은 " + LottoStatics.getLottoReturn(LottoStatics.getTotalWinnnerAmount(winningDetails), purchaseAmount) + "%입니다.");

    }
}
