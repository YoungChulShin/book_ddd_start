package study.spring.myshop.order.command.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class OrderNo {

    private String number;

    public OrderNo(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        OrderNo other = (OrderNo)obj;
        return Objects.equals(number, other.number);
    }
}
