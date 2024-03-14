package domain;

import java.util.HashSet;
import java.util.List;

public class LottoWinnerNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private final int LOW_BONUS_NUMBER = 1;
    private final int HIGH_BONUS_NUMBER = 45;

    private final String NOT_RANGE_BONUS_NUMBER = "[ERROR] 보너스 번호가 1 ~ 45 사이 숫자가 아닙니다.";
    private final String DUPLICATE_WINNER_NUMBERS_AND_BONUSNUMBER = "[ERROR] 당첨 로또 번호와 보너스 번호가 중복됩니다.";
    private final String DUPLICATED_WINNER_NUMBERS = "[ERROR] 로또 번호가 중복됩니다.";
    private final String NOT_RANGE_WINNER_NUMBERS = "[ERROR] 로또 번호가 1 ~ 45 사이 숫자가 아닙니다.";

    public LottoWinnerNumber(List<Integer> numbers, int bonusNumber) {
        validationWinningNumbers(numbers);
        validationBonusNumber(bonusNumber);
        validationDulicationNumbers(numbers, bonusNumber);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validationBonusNumber(int bonusNumber) {
        if(!isBetweenOneAndFortyFive(bonusNumber)){
            throw new IllegalArgumentException(NOT_RANGE_BONUS_NUMBER);
        }
    }

    private boolean isBetweenOneAndFortyFive(int bonusNumber) {
        if(LOW_BONUS_NUMBER > bonusNumber || bonusNumber > HIGH_BONUS_NUMBER){
            return false;
        }
        return true;
    }

    private void validationDulicationNumbers(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_WINNER_NUMBERS_AND_BONUSNUMBER);
        }

    }

    private void validationWinningNumbers(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != 6){
            throw new IllegalArgumentException(DUPLICATED_WINNER_NUMBERS);
        }
        if(!isBetweenOneAndFortyFive(numbers)){
            throw new IllegalArgumentException(NOT_RANGE_WINNER_NUMBERS);
        }
    }

    private boolean isBetweenOneAndFortyFive(List<Integer> numbers) {
        for(int winnerNumber : numbers){
            if( LOW_BONUS_NUMBER > winnerNumber || winnerNumber > HIGH_BONUS_NUMBER){
                return false;
            }
        }
        return true;
    }

    // 로또 번호 개수는 6개
    // 로또 번호는 1 ~ 45 인 숫자
    // 로또 번호는 중복 X

}
