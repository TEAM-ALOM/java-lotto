package lotto.domain.result;

import lotto.domain.number.Lotto;
import lotto.domain.number.LottoArray;
import lotto.domain.number.WinningNumbers;

import java.util.*;

public class Result {

    public static Map<MatchedPlace, Integer> getMatchedDetails(LottoArray lottoArray, WinningNumbers winningNumbers) {
        Map<MatchedPlace, Integer> matchedDetails = generateMatchedDetails();
        for (Lotto lotto : lottoArray.getLottoArray()) {
            int matchedCount = compareNumbersWithWinningNumbers(lotto, winningNumbers);
            boolean containsBonusNumber = compareNumbersWithBonusNumber(lotto, winningNumbers,matchedCount);
            MatchedPlace matchedPlace = MatchedPlace.findPlace(matchedCount, containsBonusNumber);
            matchedDetails.replace(matchedPlace, matchedDetails.get(matchedPlace) + 1);
        }
        return matchedDetails;

    }
    public static Map<MatchedPlace, Integer> generateMatchedDetails() {
        Map<MatchedPlace, Integer> matchedDetails = new EnumMap<>(MatchedPlace.class);
        Arrays.stream(MatchedPlace.values()).forEach(winningRank -> matchedDetails.put(winningRank, 0));
        return matchedDetails;
    }
    private static int compareNumbersWithWinningNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbersArray = winningNumbers.getArray();
        return (int) numbers.stream()
                .filter(winningNumbersArray::contains)
                .count();
    }
    private static boolean compareNumbersWithBonusNumber(Lotto lotto, WinningNumbers winningNumbers, int matchedCount) {
        if (matchedCount != 5) {
            return false;
        }
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
