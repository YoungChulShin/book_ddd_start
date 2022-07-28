package study.ddd.myshop.order.command.domain

import study.ddd.myshop.common.model.Address

data class ShippingInfo(
    val receiver: Receiver,
    val address: Address
)