package study.ddd.myshop.order.command.domain

class Order(
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
        this.totalAmounts = orderLines.sumOf { it.amounts }
    }


    fun changeShippingInfo(shippingInfo: ShippingInfo) {
        if (isShippingChangeable()) {
            throw IllegalArgumentException("can't change shipping in $state")
        }

        this.shippingInfo = shippingInfo
    }

    private fun isShippingChangeable(): Boolean {
        return state == OrderState.PAYMENT_WAITING ||
                state == OrderState.PREPAIRING
    }
}