package study.spring.myshop.common.model;

import lombok.Getter;

@Getter
public class Email {
    private String address;

    public Email(String address) {
        this.address = address;
    }
}
