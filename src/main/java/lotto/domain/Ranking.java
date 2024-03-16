package lotto.domain;

import lotto.view.OutputView;

public enum Ranking {
    first(6,2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    second(5,30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    third(5,1_500_000, "5개 일치 (1,500,000원) - "),

    fourth(4,50_000, "4개 일치 (50,000원) - "),
    fifth(3,5_000, "3개 일치 (5,000원) - "),
    miss(0,0,"");

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinAmount() {
        return winAmount;
    }
    private boolean counter(int matchCount){
        return this.matchCount == matchCount;
    }
    public void printMessage(int cnt){
        if (this!=miss){
            OutputView.printSuccessMessage(message,cnt);
        }
    }


    Ranking(int matchCount, int winAmount, String message){
        this.matchCount = matchCount;
        this.winAmount = winAmount;
        this.message = message;
    }
    private static final int winMinCount = 3;
    private static final String errorMessage = "[ERROR]";

    private int matchCount;
    private int winAmount;
    private String message;
    public static Ranking valueOf(int matchCount,boolean matchBonus){
        if (matchCount < winMinCount){
            return miss;
        }
        if (second.counter(matchCount) && matchBonus){
            return second;
        }
        for (Ranking rank : values()){
            if (rank.counter(matchCount)&&rank != second){
                return rank;
            }
        }
        throw new IllegalArgumentException(errorMessage);
    }

}
