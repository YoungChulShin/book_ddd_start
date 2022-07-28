package study.spring.myshop.catalog.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import study.spring.myshop.catalog.domain.category.Category;
import study.spring.myshop.catalog.domain.category.CategoryId;
import study.spring.myshop.common.jpa.MoneyConverter;
import study.spring.myshop.common.model.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_id")
    private List<Image> images = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
