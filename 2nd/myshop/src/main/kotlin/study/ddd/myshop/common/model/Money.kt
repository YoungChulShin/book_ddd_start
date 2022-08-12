package study.ddd.myshop.common.model

import javax.persistence.Access
import javax.persistence.AccessType
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Money(
    @Column(name = "money_value")
    @Access(AccessType.FIELD)
    val value: Int
) {

    fun add (money: Money): Money = Money(value + money.value)

    fun multiply(multiplier: Int): Money = Money(value * multiplier)
}