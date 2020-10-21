package study.spring.myshop.order.command.domain;

import lombok.Getter;
import study.spring.myshop.catalog.domain.product.Product;
import study.spring.myshop.common.model.Money;

@Getter
public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
