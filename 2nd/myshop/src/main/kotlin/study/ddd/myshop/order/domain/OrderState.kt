package study.ddd.myshop.order.domain

enum class OrderState {
    PAYMENT_WAITING,
    PREPAIRING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELLED
}