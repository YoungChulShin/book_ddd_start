package study.spring.myshop.order.command.domain;

import study.spring.myshop.common.model.Money;

import java.util.List;

public class Order {

    private OrderState state;
    private ShippingInfo shippingInfo;
    private List<OrderLine> orderLines;
    private Money totalAmounts;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }


    /**
     * 출고 상태로 변경하기
     */
    public void changeShipped() {

    }

    /**
     * 배송지 정보 변경하기
     */
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!isShippingChangeable()) {
            throw new IllegalStateException("cant change shipping in " + state);
        }

        this.shippingInfo = newShippingInfo;
    }

    /**
     * 주문 취소하기
     */
    public void cancel() {

    }

    /**
     * 결제완료로 변경하기
     */
    public void completePayment() {

    }

    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING ||
                state == OrderState.PREPARING;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calcualteTotalAmounts();

    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calcualteTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream().mapToInt(OrderLine::getAmounts).sum());
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }

        this.shippingInfo = shippingInfo;
    }
}
