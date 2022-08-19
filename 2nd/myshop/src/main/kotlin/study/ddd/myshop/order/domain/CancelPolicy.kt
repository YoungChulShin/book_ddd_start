package study.ddd.myshop.order.domain

interface CancelPolicy {

    fun hasCancellationPermission
}