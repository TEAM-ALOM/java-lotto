package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);      //숫자 6개 인지 확인
        checkDuplicate(numbers);    //중복된 숫자 있는지 확인
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private boolean checkBonusNumber(List<Integer> numbers, int bonusNumber){       //보너스 숫자 일치 여부 확인
        if(numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    private int checkWinningNumbers(List<Integer> numbers, List<Integer> winningNumbers){   //일치하는 숫자 개수 확인
        int cnt = 0;
        for(int i = 0 ; i < numbers.size() ; i++){
            if(winningNumbers.contains(numbers.get(i))){
                cnt += 1;
            }
        }
        return cnt;
    }

    private void checkDuplicate(List<Integer> numbers){    //중복 숫자 확인
        Set<Integer> set =  new HashSet<>(numbers);

        if(numbers.size() != set.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }
}
