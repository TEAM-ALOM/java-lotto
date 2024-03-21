package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLottoResult {
    private final Map<Result, Integer> map = new EnumMap<>(Result.class);
    private int totalPrice = 0;

    private void setMap() {
        map.put(Result.FIRST, 0);
        map.put(Result.SECOND, 0);
        map.put(Result.THIRD, 0);
        map.put(Result.FORTH, 0);
        map.put(Result.FIFTH, 0);
    }

    public MyLottoResult() {
        setMap();
    }

    public void calculateResult(List<Lotto> myLotto, WinningLotto winningLotto){
        for(Lotto lotto : myLotto){
            int matchingCount = countMatchingNumbers(lotto, winningLotto);
            boolean containsBonusNumber = containsNumber(lotto, winningLotto.getBonusNumber());
            Result result = Result.findLottoResult(matchingCount, containsBonusNumber);
            if(result.equals(Result.NONE)) continue;
            map.put(result, map.get(result) + 1);
        }


    }
    private static int countMatchingNumbers(Lotto myLotto, WinningLotto winningLotto){
        return (int) myLotto.getNumbers().stream()
                .filter(winningLotto.getWinningLotto().getNumbers()::contains)
                .count();
    }
    private static boolean containsNumber(Lotto myLotto, int winningLotto){
        return myLotto.getNumbers().contains(winningLotto);
    }
    public void getLottoResult(){
        System.out.println("당첨 통계\n---");
        for (Map.Entry<Result, Integer> entry : map.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
            System.out.println(getResultString(entry.getKey(), entry.getValue()));
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private static String getResultString(Result result, int count) {

        if(result == Result.SECOND){
            return result.getCountCorrectNumber() +
                    "개 일치, 보너스볼 일치 (" +
                    result.getPriceFormatted() +
                    ") - " +
                    count +
                    "개";
        }
        return  result.getCountCorrectNumber() +
                "개 일치 (" +
                result.getPriceFormatted() +
                ") - " +
                count +
                "개";
    }

}
