package study.ddd.myshop.order.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Orderer (
    @Column
    val name: String
)