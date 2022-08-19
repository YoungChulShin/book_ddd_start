package study.ddd.myshop.order.domain

import javax.persistence.*

@Entity
@Table(name = "purchase_order")
class Order(
    @EmbeddedId
    val number: OrderNo,

    @Column
    @AttributeOverride(name = "name", column = Column(name = "orderer_name"))
    val orderer: Orderer,

    @ElementCollection
    @CollectionTable(
        name = "order_lines",
        joinColumns = [JoinColumn(name = "order_id")]
    )
    var orderLines: List<OrderLine> = listOf(),

    @Column
    var state: OrderState,

    @Column
    @AttributeOverrides(
        AttributeOverride(name = "receiver.name", column = Column(name = "receiver_name")),
        AttributeOverride(name = "receiver.phoneNumber", column = Column(name = "receiver_phone_number")),
        AttributeOverride(name = "address.address1", column = Column(name = "destination_address1")),
        AttributeOverride(name = "address.address2", column = Column(name = "destination_address2")),
        AttributeOverride(name = "address.zipCode", column = Column(name = "destination_zip_code")),
    )
    var shippingInfo: ShippingInfo
) {
//    private var totalAmounts: Int = 0

//    init {
//        updateOrderLines(orderLines)
//    }
//
//    private fun updateOrderLines(orderLines: List<OrderLine>) {
//        verifyAtLeastOneOrMoreOrderLines(orderLines)
//        this.orderLines = orderLines
//        calculateTotalAmounts()
//    }

//    private fun verifyAtLeastOneOrMoreOrderLines(orderLines: List<OrderLine>) {
//        if (orderLines.isEmpty()) {
//            throw IllegalArgumentException("no OrderLine")
//        }
//    }
//
//    private fun calculateTotalAmounts() {
//        this.totalAmounts = orderLines.sumOf { it.amounts.value }
//    }
//
//
//    fun changeShippingInfo(shippingInfo: ShippingInfo) {
//        verifyYetShipped()
//        this.shippingInfo = shippingInfo
//    }
//
//    fun cancel() {
//        verifyYetShipped()
//        this.state = OrderState.CANCELLED
//    }
//
//    private fun verifyYetShipped() {
//        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPAIRING) {
//            throw IllegalArgumentException("already shipped")
//        }
//    }
}