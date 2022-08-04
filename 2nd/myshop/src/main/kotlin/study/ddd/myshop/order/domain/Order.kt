package study.ddd.myshop.order.domain

class Order(
    val orderer: Orderer,
    orderLines: List<OrderLine>,
    var state: OrderState,
    var shippingInfo: ShippingInfo
) {
    private lateinit var orderLines: List<OrderLine>
    private var totalAmounts: Int = 0

    init {
        setOrderLines(orderLines)
    }

    private fun setOrderLines(orderLines: List<OrderLine>) {
        verifyAtLeastOneOrMoreOrderLines(orderLines)
        this.orderLines = orderLines
        calculateTotalAmounts()
    }

    private fun verifyAtLeastOneOrMoreOrderLines(orderLines: List<OrderLine>) {
        if (orderLines.isEmpty()) {
            throw IllegalArgumentException("no OrderLine")
        }
    }

    private fun calculateTotalAmounts() {
        this.totalAmounts = orderLines.sumOf { it.amounts.value }
    }


    fun changeShippingInfo(shippingInfo: ShippingInfo) {
        verifyYetShipped()
        this.shippingInfo = shippingInfo
    }

    fun cancel() {
        verifyYetShipped()
        this.state = OrderState.CANCELLED
    }

    private fun verifyYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPAIRING) {
            throw IllegalArgumentException("already shipped")
        }
    }
}