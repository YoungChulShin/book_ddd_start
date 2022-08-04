package study.ddd.myshop.order.application

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.ddd.myshop.common.model.Money
import study.ddd.myshop.customer.domain.CustomerRepository
import study.ddd.myshop.order.domain.CalculateDiscountService

@Service
class OrderService(
    private val orderRepository: CustomerRepository,
    private val customerRepository: CustomerRepository,
    private val calculateDiscountService: CalculateDiscountService,
) {
    fun calcuateDiscount(orderId: Long, customerId: Long)  {
        val order = orderRepository.findByIdOrNull(orderId)
            ?: throw IllegalArgumentException("오더가 존재하지 않습니다")
        val customer = customerRepository.findByIdOrNull(customerId)
            ?: throw IllegalArgumentException("고객 정보가 존재하지 않습니다")
//
//        return calculateDiscountService.calcuateDiscount(
//            order
//        )
    }
}