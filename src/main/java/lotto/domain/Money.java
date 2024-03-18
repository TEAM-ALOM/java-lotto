package lotto.domain;

import java.util.Objects;

public class Money {

    private final long amount;
    public static final Money Zero = Money.won(0L);

    public Money(long amount) {
        this.amount = amount;
    }

    public Money RemainMoney(Money other){ //계산하고 남은 돈 반환
        return new Money (this.amount % other.amount);
    }

    public static Money won(long amount){
        return new Money(amount);
    }

    public boolean isGreaterEqualthan(Money other){
        if(amount >= other.amount) return true;
        else return false;
    }

    public long divide(Money other){
        return (amount / other.amount);
    }

    public Long getAmount() {
        return amount;
    }

    public Money times(long count) {
        return new Money(this.amount * count);
    }

    public Money plus(Money other) {
        return new Money(this.amount + other.amount);
    }

    public long floorDivide(Money other) {
        return Math.floorDiv(this.amount, other.amount);
    }
    public Money calculateRemainder(Money other) {
        return new Money(this.amount % other.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount + "원";
    }
}
