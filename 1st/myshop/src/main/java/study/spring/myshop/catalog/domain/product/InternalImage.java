package study.spring.myshop.catalog.domain.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("II")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InternalImage extends Image {

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return "/images/original/" + getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailUrl() {
        return "/images/thumbnail/"+getPath();
    }
}
