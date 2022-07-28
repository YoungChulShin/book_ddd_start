package study.spring.myshop.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Random;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Getter
    @EmbeddedId
    private MemberId id;

    @Getter
    private String name;

    @Embedded
    private Password password;

    private boolean blocked;

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public void initializePassword() {
        String newPassword = generateRandomPassword();
        this.password = new Password(newPassword);  // value 타입이니까 새로 할당
        //Events.raise(new PasswordChangedEvent(this.id, password));
    }

    private String generateRandomPassword() {
        Random random = new Random();
        int number = random.nextInt();
        return Integer.toHexString(number);
    }

    public void changePassword(String currentPassword, String newPassword) {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }

        this.password = new Password(newPassword);
    }
}
