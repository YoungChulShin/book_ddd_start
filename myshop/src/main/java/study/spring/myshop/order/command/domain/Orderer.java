package study.spring.myshop.order.command.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import study.spring.myshop.member.domain.MemberId;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderer {

    @Embedded
    @AttributeOverrides(    // memberId를 OrdererID로 재정의
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
