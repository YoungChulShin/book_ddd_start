package study.ddd.myshop.order.command.domain

import study.ddd.myshop.catalog.command.domain.Product

class OrderLine(
    val product: Product,
    val price: Int,
    val quantity: Int
) {

    val amounts: Int = calculateAmounts()

    private fun calculateAmounts(): Int = price * quantity
}