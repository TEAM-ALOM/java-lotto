package domain;

import java.util.*;

public class LottoStatics {


    /**
     * 당첨 번호와 로또 번호의 일치 개수 파악 기능 -> 개수 비교하는 메소드 -> 사용한 메소드로 구한 정보를 WinnerLank enum 활용하여 winnerLottos에 저장
     * 당첨 번호, 각 로또 번호 입력 -> 생성자로 주입
     *
     * 총 수익률 판별 - (로또 구매 금액 - 당첨 금액 합계) / 로또 구매 금액 * 100
     */

    private final int INITAIL_NUMBER = 0;


    public Map<WinningRank, Integer> getWinningDetails(Lottos lottos, LottoWinnerNumber lottoWinnerNumber){
        Map<WinningRank, Integer> winnerDetails = createWinnerDetails();
        for(Lotto lotto : lottos.getLottos()){
            int matchCount = countMatchingNumbers(lottoWinnerNumber, lotto);
            boolean containsBonusNumber = hasBonusNumber(lottoWinnerNumber.getBonusNumber(), lotto);
            WinningRank winningRank = WinningRank.findWinningRank(matchCount, containsBonusNumber);
            winnerDetails.replace(winningRank, winnerDetails.get(winningRank) + 1);
        }
        return winnerDetails;
    }
    public Map<WinningRank, Integer> createWinnerDetails() {
        Map<WinningRank, Integer> winnerDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winnerDetails.put(winningRank, INITAIL_NUMBER));

        return winnerDetails;
    }

    private boolean hasBonusNumber(int bonusNumber, Lotto lotto) {
        boolean contaisBonusNumber = false;
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.contains(bonusNumber)){
            contaisBonusNumber = true;
        }
        return contaisBonusNumber;
    }

    private int countMatchingNumbers(LottoWinnerNumber lottoWinnerNumber, Lotto lotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i = 0; i< lottoNumbers.size(); i++){
            if(lottoNumbers.contains(lottoWinnerNumber.getWinningNumbers().get(i))){
                count++;
            }
        }
        return count;
    }
}
