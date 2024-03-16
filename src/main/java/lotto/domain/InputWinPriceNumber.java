package lotto.domain;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.SortLottoNumber.sortNumbers;

public class InputWinPriceNumber {

    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static List<Integer> getWinPriceNumber() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println(LOTTO_NUMBER_MESSAGE);
        String[] str = readLine().split(",");

        for (int i = 0; i < 6; i++) {
            numbers.add(Integer.parseInt(str[i]));
        }

        sortNumbers(numbers);
        return numbers;
    }

    public static int getLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(readLine());
    }
}
