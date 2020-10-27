package study.spring.myshop.order.command.domain;

import java.util.List;

public interface OrderRepository {

    Order findById(OrderNo id);

    void save(Order order);

    List<Order> findByOrdererId(String ordererId, int startRow, int size);

    void delete(Order order);
}
