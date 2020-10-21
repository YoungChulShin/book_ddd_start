package study.spring.myshop.order.command.domain;

import study.spring.myshop.member.domain.MemberId;

public class Orderer {

    private MemberId memberId;

    private String name;

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
