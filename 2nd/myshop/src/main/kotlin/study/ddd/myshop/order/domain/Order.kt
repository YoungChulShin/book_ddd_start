package study.ddd.myshop.order.domain

import javax.persistence.*

@Entity
@Table(name = "order")
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val orderer: Orderer,
//    var orderLines: List<OrderLine> = listOf(),

    @Column
    var state: OrderState,

    @Column
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