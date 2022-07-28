package study.spring.myshop.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleContent {

    private String content;

    private String contentType;

    public ArticleContent(String content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }
}
