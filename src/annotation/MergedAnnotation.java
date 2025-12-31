package annotation;

import java.lang.annotation.Annotation;
import java.util.Optional;

public interface MergedAnnotation<A extends Annotation> {

    Class<A> getType();

    boolean isPresent();

    <T> T getValue(String attributeName);

    Optional<Object> getRawAttribute(String attributeName);

}
