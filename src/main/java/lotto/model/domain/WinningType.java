package lotto.model.domain;

public enum WinningType {
    MATCHES_SIX("6개 일치 (2,000,000,000원)", 2_000_000_000),
    MATCHES_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    MATCHES_FIVE("5개 일치 (1,500,000원)", 1_500_000),
    MATCHES_FOUR("4개 일치 (50,000원)", 50_000),
    MATCHES_THREE("3개 일치 (5,000원)", 5_000);

    private final String message;
    private final long profitMoney;

    WinningType(String message, long profitMoney) {
        this.message = message;
        this.profitMoney = profitMoney;
    }

    public String getMessage() {
        return message;
    }

    public long getProfitMoney() {
        return profitMoney;
    }
}
