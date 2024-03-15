package domain;

import java.util.*;

public class LottoStatics {


    private static final int INITAIL_NUMBER = 0;
    private static final int PERCENT = 100;


    public static Map<WinningRank, Integer> getWinningDetails(Lottos lottos, LottoWinnerNumber lottoWinnerNumber){
        Map<WinningRank, Integer> winnerDetails = createWinnerDetails();
        for(Lotto lotto : lottos.getLottos()){
            int matchCount = countMatchingNumbers(lottoWinnerNumber, lotto);
            boolean containsBonusNumber = hasBonusNumber(lottoWinnerNumber.getBonusNumber(), lotto);
            WinningRank winningRank = WinningRank.findWinningRank(matchCount, containsBonusNumber);
            winnerDetails.replace(winningRank, winnerDetails.get(winningRank) + 1);
        }
        return winnerDetails;
    }
    private static Map<WinningRank, Integer> createWinnerDetails() {
        Map<WinningRank, Integer> winnerDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winnerDetails.put(winningRank, INITAIL_NUMBER));

        return winnerDetails;
    }

    private static boolean hasBonusNumber(int bonusNumber, Lotto lotto) {
        boolean contaisBonusNumber = false;
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.contains(bonusNumber)){
            contaisBonusNumber = true;
        }
        return contaisBonusNumber;
    }

    private static int countMatchingNumbers(LottoWinnerNumber lottoWinnerNumber, Lotto lotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i = 0; i< lottoNumbers.size(); i++){
            if(lottoNumbers.contains(lottoWinnerNumber.getWinningNumbers().get(i))){
                count++;
            }
        }
        return count;
    }

    public static long getTotalWinnnerAmount(Map<WinningRank, Integer> winningDetails){

        return winningDetails.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinnerlottoPrice() * entry.getValue())
                .sum();
    }

    public static double getLottoReturn(long totalWinnerAmount, int purchaseAmount){
        double result = (purchaseAmount - totalWinnerAmount) / totalWinnerAmount * PERCENT;
        return Math.round(result * 10) / 10.0;
    }
}
