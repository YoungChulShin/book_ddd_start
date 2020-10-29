package study.spring.myshop.order.command.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import study.spring.myshop.common.jpa.MoneyConverter;
import study.spring.myshop.common.model.Money;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)   // ID가 Field에 위치하면 Field로, Property에 위치하면 Property로
public class Order {

    @EmbeddedId
    private OrderNo number;

    @Embedded
    private Orderer orderer;

    private OrderState state;

    @Embedded
    private ShippingInfo shippingInfo;

    @ElementCollection
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    public Order(Orderer orderer,
                 List<OrderLine> orderLines,
                 ShippingInfo shippingInfo,
                 OrderState state) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
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
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    /**
     * 주문 취소하기
     */
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    /**
     * 결제완료로 변경하기
     */
    public void completePayment() {

    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }

        this.shippingInfo = shippingInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        if (this.number == null) return false;

        Order other = (Order)obj;
        return this.number.equals(other.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }
}
