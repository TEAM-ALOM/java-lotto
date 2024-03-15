package lotto;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.findRank(matchCount, bonusMatch);
    }
}
