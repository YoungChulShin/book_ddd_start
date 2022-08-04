package study.ddd.myshop.customer.domain

import javax.persistence.*

@Entity
@Table(name = "customer")
class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
)