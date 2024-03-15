package lotto.domain.number;

import org.kokodak.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottoArray = new ArrayList<>();
    private final int ticketNumber;

    public LottoMachine(int amount) {
        validateDivisibleBy1000(amount);
        this.ticketNumber = amount / LOTTO_PRICE;
    }

    private void validateDivisibleBy1000(final int input) {
        if ((input % LOTTO_PRICE) !=0) {
            throw new IllegalArgumentException("[ERROR] " + input + "이 1,000으로 나누어 떨어지지 않습니다.");
        }
    }
    public List<Lotto> createLottoArray() {
        for (int i = 0; i < ticketNumber; i++) {
            Lotto lotto = createNumbers();
            lottoArray.add(lotto);
        }
        return lottoArray;
    }
    public Lotto createNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45,
                        6));
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }
    public int getTicketNumber() {
        return ticketNumber;
    }
}
