package study.spring.myshop.order.command.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDataRepository extends JpaRepository<Order, OrderNo> {

    Page<List<Order>> findByOrderer(Orderer orderer, Pageable pageable);
}
