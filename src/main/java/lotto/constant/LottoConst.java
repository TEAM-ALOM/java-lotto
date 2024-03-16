package lotto.constant;

public enum LottoConst {
    LOTTO_PRICE(1000),
    FIRST_PLACE_PRIZE(2000000000),
    SECOND_PLACE_PRIZE(30000000),
    THIRD_PLACE_PRIZE(1500000),
    FOURTH_PLACE_PRIZE(50000),
    FIFTH_PLACE_PRIZE(5000);

    private final Integer money;

    LottoConst(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }
}
