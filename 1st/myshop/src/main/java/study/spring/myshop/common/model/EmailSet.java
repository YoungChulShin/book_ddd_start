package study.spring.myshop.common.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class EmailSet {
    private Set<Email> emails = new HashSet<>();

    public EmailSet(Set<Email> emails) {
        emails.addAll(emails);
    }
}
