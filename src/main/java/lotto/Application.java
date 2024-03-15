package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int number = generateUniqueRandomNumber(lottoNumbers);
            lottoNumbers.add(number);
        }

        Lotto lotto = new Lotto(lottoNumbers);

        lotto.Play();
    }

    // 중복되지 않는 랜덤 숫자를 생성하는 메서드
    private static int generateUniqueRandomNumber(List<Integer> numbers) {
        int number;
        do {
            number = (int) (Math.random() * 45) + 1;
        } while (numbers.contains(number));
        return number;
    }

}
