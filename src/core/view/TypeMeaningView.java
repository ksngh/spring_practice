package core.view;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface TypeMeaningView {

    String typeName();

    Set<String> stereotypes();

    boolean hasAnnotation(Class<? extends Annotation> annotationType);

    Optional<Map<String, Object>> annotationAttributes(Class<? extends Annotation> annotationType);

    Optional<String> tagValue();
}
