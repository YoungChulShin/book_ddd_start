package study.spring.myshop.order.command.domain;

import lombok.Getter;
import study.spring.myshop.catalog.domain.product.Product;

@Getter
public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }
}
