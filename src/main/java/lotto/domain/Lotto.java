package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers){
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = from(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public List<Integer> value(){
        return numbers.stream()
                .map(LottoNumber::value)
                .collect(toList());
    }



    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
    private List<LottoNumber> from(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(toList());
    }

    public LottoPrize check(Lotto winningNumbers, LottoNumber bonusNumber) {
        int matchedCount = countMatchedNumbers(winningNumbers);
        boolean bonusNumberMatched = isBonusNumberMatched(bonusNumber);
        return LottoPrize.getEnum(matchedCount, bonusNumberMatched);
    }

    private int countMatchedNumbers(Lotto winningNumbers) {
        return (int) winningNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }


}
