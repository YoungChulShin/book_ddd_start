package study.ddd.myshop.common.model

data class Money(
    val value: Int
) {

    fun add (money: Money): Money = Money(value + money.value)

    fun multiply(multiplier: Int): Money = Money(value * multiplier)
}