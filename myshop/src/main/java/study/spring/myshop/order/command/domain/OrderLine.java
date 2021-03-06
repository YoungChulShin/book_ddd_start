package study.spring.myshop.order.command.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.myshop.catalog.domain.product.ProductId;
import study.spring.myshop.common.jpa.MoneyConverter;
import study.spring.myshop.common.model.Money;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Column(name = "price")
    @Convert(converter = MoneyConverter.class)
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    @Convert(converter = MoneyConverter.class)
    private Money amounts;

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
