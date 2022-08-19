package study.ddd.myshop.order.application

import org.springframework.stereotype.Service
import study.ddd.myshop.order.domain.OrderNo
import study.ddd.myshop.order.domain.OrderRepository

@Service
class CancelOrderService(
    val orderRepository: OrderRepository
) {

    fun cancel(orderNo: OrderNo, )
}