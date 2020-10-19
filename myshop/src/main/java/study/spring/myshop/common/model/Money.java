package study.spring.myshop.common.model;

import lombok.Getter;

@Getter
public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
