package study.ddd.myshop.order.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Receiver(
    @Column
    val name: String,
    @Column
    val phoneNumber: String
)