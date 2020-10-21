package study.spring.myshop.order.command.domain;

import lombok.Getter;

@Getter
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        //if (obj.getClass() != Receiver.class) return false;
        if (!(obj instanceof Receiver)) return false;
        Receiver other = (Receiver)obj;

        return this.name.equals(other.name) &&
                this.phoneNumber.equals(other.phoneNumber);
    }
}
