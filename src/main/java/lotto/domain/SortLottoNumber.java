package lotto.domain;

import java.util.Collections;
import java.util.List;

public class SortLottoNumber {
    public static List<Integer> sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}
