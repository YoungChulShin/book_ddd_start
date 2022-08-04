package study.ddd.myshop.order.infra

import org.springframework.stereotype.Component
import study.ddd.myshop.common.model.Money
import study.ddd.myshop.customer.domain.Customer
import study.ddd.myshop.order.domain.OrderLine
import study.ddd.myshop.order.domain.RuleDiscounter

@Component
class DroolsRuleDiscounter : RuleDiscounter {
    override fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money {
        return Money(100)
    }
}