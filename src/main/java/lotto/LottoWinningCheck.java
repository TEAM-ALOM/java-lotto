package lotto;

import java.util.*;

public class LottoWinningCheck {
    private Lottos lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    public LottoWinningCheck() {
    }

    //로또 번호와 당첨 번호 비교하는 메소드
    public int matchingLotto(Lotto lotto, List<Integer> winningNumbers){
        int cnt = 0;
        for(int num: lotto.getNumbers()){
            if(winningNumbers.contains(num)){
                cnt += 1;
            }
        }
        return cnt;
    }

    //로또 번호와 당첨 번호 비교하여 맞는 개수로 등수 확정
    public Map<Integer, Boolean> matchingNumbersCount(Lottos lottos, List<Integer> winningNumbers, int bonusNumber){
        Map<Integer, Boolean> matchingNumbersCount = new HashMap<>();
        for(Lotto lotto1: lottos.getLottos()){
            int cnt = 0;
            boolean bonusNumberMatching = false;
            cnt = matchingLotto(lotto1, winningNumbers);
            bonusNumberMatching = bonusNumberMatchingCheck(lotto1, bonusNumber);
            matchingNumbersCount.put(cnt, bonusNumberMatching);
        }
        return matchingNumbersCount;
    }
    //보너스 번호 맞는지 여부 확인
    public boolean bonusNumberMatchingCheck(Lotto lotto, int bonusNumber){
        if(lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }

    //로또 결과 map으로 표시 된 것들 몇 등이 몇 개인지 체크 후 출력
    /* 이 방식으로는 15줄 넘어가서 다른 방법 찾아야 함
    public void printResults(Map<Integer, Boolean> lottoResult){
        for(Map.Entry<Integer,Boolean> entry : lottoResult.entrySet()){
            int key = entry.getKey();
            boolean value = entry.getValue();
            if(key < 3){
                continue;
            }
            if (key == 3) {
            }
            if(key == 4){

            }
            if (key == 5) {

            }
        }
    }
    */


}
