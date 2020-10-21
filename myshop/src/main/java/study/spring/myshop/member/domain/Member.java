package study.spring.myshop.member.domain;

import lombok.Getter;

public class Member {

    @Getter
    private MemberId id;

    @Getter
    private String name;

    private Password password;

    private boolean blocked;

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }
}
