package study.ddd.myshop.order.domain

import study.ddd.myshop.common.model.Address

data class ShippingInfo(
    val receiver: Receiver,
    val address: Address
)