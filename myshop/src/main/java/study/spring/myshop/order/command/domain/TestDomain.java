package study.spring.myshop.order.command.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestDomain {

    @Id
    @GeneratedValue
    private Long id;

    private String test;
}
