package jp.co.biglobe.warikan.domain.amount;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@SuppressWarnings("serial")
public class Amount implements Serializable {
    @Getter
    private int amount;

    public static Amount zero() {
        return new Amount(0);
    }

    public Amount add(Amount other) {
        return new Amount(this.amount + other.amount);
    }

    public Amount subtract(Amount other) {
        return new Amount(this.amount - other.amount);
    }

    public Amount divide(int by) {
        return new Amount(this.amount / by);
    }

    public int divide(Amount by) {
        return this.amount / by.getAmount();
    }

    public Amount remainder(int divideBy) {
        return new Amount(this.amount % divideBy);
    }

    public Amount multiply(int by) {
        return new Amount(this.amount * by);
    }

    public boolean lessThan(Amount other) {
        return amount < other.amount;
    }

}
