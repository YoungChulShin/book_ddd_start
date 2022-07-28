package study.spring.myshop.catalog.domain.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category {

    @EmbeddedId
    private CategoryId id;

    @Column(name = "name")
    private String name;

    public Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }
}
