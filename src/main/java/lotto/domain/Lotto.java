package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private static final int minNumber = 1;
    private static final int maxNumber = 45;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers){
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLottoNumbers(){
        return numbers;
    }
    public int countMatch(Lotto winLotto){
        return (int) numbers.stream().filter(winLotto::containNumber).count();
    }
    public boolean containNumber(int number){
        return numbers.contains(number);
    }
    private void validate(List<Integer> numbers){
        if(numbers.size() != 6){
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }
    private void validateOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i< numbers.size();i++){
            overlapCheck.add(numbers.get(i));
        }
        if (overlapCheck.size() != 6){
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(List<Integer> numbers){
        for (int winNumber = 0;winNumber<numbers.size();winNumber++){
            if (numbers.get(winNumber) < minNumber || numbers.get(winNumber) > maxNumber){
                ExceptionMessage.rangeException();
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if (numbers.contains(bonusNumber)){
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }

}