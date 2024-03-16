package lotto.validator;

import lotto.domain.Lotto;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    public static int validateInputNumber(String input) {
        if (!Pattern.matches("^[1-9]\\d*000$", input)){
            throw new IllegalArgumentException("[ERROR] 입력 금액이 1000으로 나누어 떨어지는 숫자여야합니다.");
        }

        return Integer.parseInt(input);
    }

    public static Lotto validateInputLottoNumber(String input) {
        List<String> lottoNumbers = List.of(input.split(","));

        for (String number: lottoNumbers) {
            if (!Pattern.matches("\\b[1-9]|[1-3]\\d|4[0-5]\\b", number)) {
                throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
            }
        }

        return new Lotto(lottoNumbers.stream()
                .map(number -> Integer.parseInt(number))
                .distinct()
                .collect(Collectors.toList()));
    }

    public static int validateInputBonusNumber(String input) {
        if (!Pattern.matches("\\b[1-9]|[1-3]\\d|4[0-5]\\b", input)) {
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }
}
