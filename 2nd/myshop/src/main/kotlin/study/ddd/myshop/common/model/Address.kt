package study.ddd.myshop.common.model

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Address(
    @Column
    val address1: String,
    @Column
    val address2: String,
    @Column
    val zipCode: String
)