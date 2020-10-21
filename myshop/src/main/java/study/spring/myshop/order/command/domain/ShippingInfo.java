package study.spring.myshop.order.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.spring.myshop.common.model.Address;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;

    public ShippingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }
}

