package lotto.validator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    public static int validateInputNumber(String input) {
        // 1000으로 나누어 떨어지는 정수인지 확인한다. 아닐시 에러를 발생시킴
        if (!Pattern.matches("^[1-9]\\d*000$", input)){
            throw new IllegalArgumentException("[ERROR] 입력 금액이 1000으로 나누어 떨어지는 숫자여야합니다.");
        }

        return Integer.parseInt(input);
    }

    public static Lotto validateInputLottoNumber(String input) {
        List<String> lottoNumbers = List.of(input.split(","));

        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        }

        List<Integer> lotto = new ArrayList<>();

        for (String number: lottoNumbers) {
            lotto.add(validateNumber(number));
        }

        return new Lotto(lotto);
    }

    public static int validateNumber(String input) {
        if (!Pattern.matches("\\b[1-9]|[1-3]\\d|4[0-5]\\b", input)) {
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }
}
