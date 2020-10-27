package study.spring.myshop.order.infra.repository;

import org.springframework.stereotype.Repository;
import study.spring.myshop.order.command.domain.Order;
import study.spring.myshop.order.command.domain.OrderNo;
import study.spring.myshop.order.command.domain.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findById(OrderNo id) {
        return em.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int size) {
        TypedQuery<Order> query = em.createQuery(
                "select o from Order o " +
                        "where o.orderer.memberId.id = :ordererId " +
                        "order by o.number.number desc", Order.class);

        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public void delete(Order order) {
        em.remove(order);
    }
}
