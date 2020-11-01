package study.spring.myshop.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "article")
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "content", column = @Column(table = "article_content")),
            @AttributeOverride(name = "contentType", column = @Column(table = "article_content"))
    })
    private ArticleContent articleContent;

    public Article(String title, ArticleContent articleContent) {
        this.title = title;
        this.articleContent = articleContent;
    }
}
