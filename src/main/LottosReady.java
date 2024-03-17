package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class LottosReady {
    private List<Integer> numbers;

    // 생성자에서 로또번호 초기화
    public LottosReady(){
        // 1부터 45까지의 범위에서 중복되지 않는 6개의 숫자를 추출
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // 리스트를 오름차순으로 정렬
        Collections.sort(numbers);
    }

    // 로또 번호 출력 메서드
    public void printNumbers(){
        System.out.println(numbers);
    }

    public int match(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // numbers getter
    public List<Integer> getNumbers() {
        return numbers;
    }

}
