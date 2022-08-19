package study.ddd.myshop.order.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class OrderNo (
    @Column(name = "order_number")
    val number: String
) : java.io.Serializable {

    companion object {
        fun of(number: String) : OrderNo = OrderNo(number)
    }
}