package study.spring.myshop.catalog.domain.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "EI")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalImage extends Image{

    public ExternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailUrl() {
        return null;
    }
}
