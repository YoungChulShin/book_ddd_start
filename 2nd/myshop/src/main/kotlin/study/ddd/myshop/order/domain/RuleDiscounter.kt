package study.ddd.myshop.order.domain

import study.ddd.myshop.common.model.Money
import study.ddd.myshop.customer.domain.Customer

interface RuleDiscounter {

    fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money
}