package study.ddd.myshop.order.domain

import study.ddd.myshop.common.model.Money
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class OrderLine(
    val productId: Long,
    @Embedded
    val price: Money,
    val quantity: Int
) {
    @javax.persistence.Transient
    val amounts: Money = calculateAmounts()

    private fun calculateAmounts(): Money = price.multiply(quantity)
}