package study.ddd.myshop.order.domain

import study.ddd.myshop.common.model.Address
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class ShippingInfo(
    val receiver: Receiver,
    val address: Address
)