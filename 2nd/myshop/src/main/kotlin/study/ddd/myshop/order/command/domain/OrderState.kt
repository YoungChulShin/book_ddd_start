package study.ddd.myshop.order.command.domain

enum class OrderState {
    PAYMENT_WAITING,
    PREPAIRING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED
}