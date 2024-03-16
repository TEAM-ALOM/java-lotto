package lotto;

import java.util.Map;

public class Output {
    public static void printLottoAmount(int lottoAmount){
        System.out.println(lottoAmount +"개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos){
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }
    public static void printResults (Map<WinningRank, Integer> winningInfo){
        for(Map.Entry<WinningRank,Integer> entry : winningInfo.entrySet()){
            WinningRank winningRank = entry.getKey();
            int value = entry.getValue();
            System.out.println( winningRank.ordinal()+1 + "개 일치 (" + winningRank.getWinningPrice() +"원) - " + value + "개");
        }
    }

    public static double calcEarning(Map<WinningRank, Integer> winningInfo, int money){
        int sum = 0;
        for(Map.Entry<WinningRank,Integer> entry : winningInfo.entrySet()){
            WinningRank winningRank = entry.getKey();
            int value = entry.getValue();
            if(value >= 1){
                sum += value * winningRank.getWinningPrice();
            }
        }
        return Math.round(sum/money);
    }

}
