package study.ddd.myshop.order.command.domain

import study.ddd.myshop.catalog.command.domain.Product
import study.ddd.myshop.common.model.Money

class OrderLine(
    val product: Product,
    val price: Money,
    val quantity: Int
) {

    val amounts: Money = calculateAmounts()

    private fun calculateAmounts(): Money = price.multiply(quantity)
}