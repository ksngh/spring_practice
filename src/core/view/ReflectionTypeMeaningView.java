package core.view;

import core.annotation.Stereotype;
import core.annotation.Tag;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

public final class ReflectionTypeMeaningView implements TypeMeaningView {

    private final Class<?> type;

    public ReflectionTypeMeaningView(Class<?> type) {
        this.type = type;
    }

    @Override
    public String typeName() {
        return type.getName();
    }

    @Override
    public Set<String> stereotypes() {
        Set<String> result = new LinkedHashSet<>();
        collect(type, result, new HashSet<>());
        return Collections.unmodifiableSet(result);
    }

    @Override
    public boolean hasAnnotation(Class<? extends Annotation> annotationType) {
        return type.isAnnotationPresent(annotationType);
    }

    @Override
    public Optional<Map<String, Object>> annotationAttributes(Class<? extends Annotation> annotationType) {
        Annotation ann = type.getAnnotation(annotationType);
        if (ann == null) return Optional.empty();

        Map<String, Object> values = new LinkedHashMap<>();
        try {
            for (var m : ann.annotationType().getDeclaredMethods()) {
                values.put(m.getName(), m.invoke(ann));
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return Optional.of(values);
    }

    @Override
    public Optional<String> tagValue() {
        Tag tag = type.getAnnotation(Tag.class);
        return tag == null ? Optional.empty() : Optional.of(tag.value());
    }

    private void collect(AnnotatedElement element, Set<String> out, Set<Class<?>> visited) {
        for (Annotation ann : element.getAnnotations()) {
            Class<? extends Annotation> at = ann.annotationType();
            if (!visited.add(at)) continue;

            Stereotype stereotype = at.getAnnotation(Stereotype.class);
            if (stereotype != null) {
                out.add(stereotype.value());
            }

            collect(at, out, visited);
        }
    }
}
