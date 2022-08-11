package study.ddd.myshop.order.domain

import org.springframework.stereotype.Service
import study.ddd.myshop.common.model.Money
import study.ddd.myshop.customer.domain.Customer
import study.ddd.myshop.customer.domain.CustomerRepository

@Service
class CalculateDiscountService(
    private val ruleDiscounter: RuleDiscounter,
) {
    fun calcuateDiscount(orderLines: List<OrderLine>, customer: Customer) : Money =
        ruleDiscounter.applyRules(customer, orderLines)
}