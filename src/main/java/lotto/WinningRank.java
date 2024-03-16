package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum WinningRank{    //코드 중 15줄 안에 해결되지 않는 메소드가 있어 다른 분 코드 참고하여 열거형 생성,
    LAST_PLACE(0, false, 0),
    FIFTH_PLACE(3, false,5_000),

    FOURTH_PLACE(4,false,50_000),
    THIRD_PLACE(5,false,1_500_500),
    SECOND_PLACE(5,true,30_000_000),
    FIRST_PLACE(6,false,2_000_000_000);

    private final int matchingCount;
    private final boolean containsBonusNumber;



    private final int winningPrice;
    private static final Map<WinningRank, Integer> winningInfo = new EnumMap<WinningRank, Integer>(WinningRank.class);
    WinningRank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static WinningRank findWinningRank(int matchingCount, boolean containsBonusNumber){
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchingCount == matchingCount)
                .filter(winningRank -> winningRank.containsBonusNumber == containsBonusNumber)
                .findFirst()
                .orElse(WinningRank.LAST_PLACE);
    }

    /*        public int getWinningCount(Map<WinningRank,Integer> winningInfo, int key){
                return winningInfo.get(key);
            }*/
    //enum 판별 후 갯수 파악
    public static Map<WinningRank, Integer> findWinningCounts(Map<Integer, Boolean> lottoResult){
        for(Map.Entry<Integer,Boolean>entry : lottoResult.entrySet()) {
            int key = entry.getKey();
            boolean value = entry.getValue();
            winningInfo.put(findWinningRank(key,value), 0);
        }
        for(Map.Entry<Integer,Boolean>entry : lottoResult.entrySet()){
            int key = entry.getKey();
            boolean value = entry.getValue();
            WinningRank winningRank = WinningRank.findWinningRank(key, value);
            winningInfo.put(findWinningRank(key,value), winningInfo.get(findWinningRank(key,value)) + 1);
        }
        return winningInfo;
    }
    public int getWinningPrice() {
        return winningPrice;
    }
}