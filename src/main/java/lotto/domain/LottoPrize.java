package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum LottoPrize {

    _1ST_PRIZE(6, Money.won(2_000_000_000L)),
    _2ND_PRIZE(5, Money.won(30_000_000L)),
    _3RD_PRIZE(5, Money.won(1_500_000L)),
    _4TH_PRIZE(4, Money.won(50_000L)),
    _5TH_PRIZE(3, Money.won(5_000L)),
    _NOTHING(0, Money.Zero);

    private final Integer matchCount;
    private final Money prize;

    LottoPrize(Integer match, Money prize) {
        this.matchCount = match;
        this.prize = prize;
    }

    public Money calculatePrize(Long count) {
        return prize.times(count);
    }

    public static LottoPrize getEnum(int matchedCount, boolean bonusNumberMatched) {
        LottoPrize lottoPrize = getLottoPrize(matchedCount);
        return checkSecondPrize(lottoPrize, bonusNumberMatched);
    }

    private static LottoPrize getLottoPrize(int matchedCount) {
        return lowestPrizeOrder().stream()
                .filter(prize -> prize.matchCount == matchedCount)
                .findAny()
                .orElse(_NOTHING);
    }

    public static List<LottoPrize> lowestPrizeOrder() {
        return Arrays.stream(values())
                .filter(lottoPrize -> !lottoPrize.equals(_NOTHING))
                .sorted(Comparator.comparingLong(o -> o.prize.getAmount()))
                .collect(toList());
    }

    private static LottoPrize checkSecondPrize(LottoPrize lottoPrize, boolean bonusNumberMatched) {
        if (lottoPrize == _3RD_PRIZE && bonusNumberMatched) {
            return _2ND_PRIZE;
        }
        return lottoPrize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize.getAmount();
    }
}
