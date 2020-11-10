package study.spring.myshop.order.command.domain;

import lombok.Getter;

@Getter
public class OrderCanceledEvent {

    private String orderNumber;

    public OrderCanceledEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
