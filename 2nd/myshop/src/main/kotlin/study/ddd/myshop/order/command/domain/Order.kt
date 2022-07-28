package study.ddd.myshop.order.command.domain

class Order(
    var state: OrderState,
    var shippingInfo: ShippingInfo
) {

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