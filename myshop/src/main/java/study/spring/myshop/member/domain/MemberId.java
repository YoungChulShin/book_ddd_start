package study.spring.myshop.member.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class MemberId implements Serializable {

    private String id;

    public MemberId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return Objects.equals(id, memberId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
