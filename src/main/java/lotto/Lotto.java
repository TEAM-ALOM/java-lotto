package lotto;

import domain.LottoRepository;
import service.LottoService;
import view.UserInput;
import view.View;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
    public static void MakeLotto() {
        do {
            LottoRepository.addLotto(LottoService.MakeLottoNum());
            UserInput.cnt++;
        }
        while(UserInput.cnt != UserInput.getCountBuyLotto());
    }

    public static Lotto newLottoWinningNumbers(String WinningNumbers) {
        Set<Integer> setLottoNumbers = new HashSet<>();
        for (String number : WinningNumbers.split(",")) {
            validateInteger(number);
            setLottoNumbers.add(Integer.parseInt(number));
        }
        return new Lotto((List<Integer>) setLottoNumbers);
    }
    private static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 번호는 1~45 정수만 입력 가능합니다.");
        }
    }
    // TODO: 추가 기능 구현

}
