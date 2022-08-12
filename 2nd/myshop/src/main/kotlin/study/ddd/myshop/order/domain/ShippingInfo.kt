package study.ddd.myshop.order.domain

import study.ddd.myshop.common.model.Address
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class ShippingInfo(

    @Column
    val receiver: Receiver,
    @Column
    val address: Address
)