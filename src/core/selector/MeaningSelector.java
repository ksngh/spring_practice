package core.selector;

import core.registry.MeaningRegistry;
import core.view.TypeMeaningView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class MeaningSelector {

    private final MeaningRegistry registry;

    public MeaningSelector(MeaningRegistry registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    public List<TypeMeaningView> selectAll() {
        return registry.views()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<TypeMeaningView> selectByStereotype(String stereotype) {
        return registry.views()
                .stream()
                .filter(v -> v.stereotypes().contains(stereotype))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<TypeMeaningView> selectByTag(String tag) {
        return registry.views()
                .stream()
                .filter(v -> v.tagValue().isPresent())
                .filter(v -> v.tagValue().get().equals(tag))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<TypeMeaningView> selectByAnnotation(Class<?> annotationType) {
        return registry.views()
                .stream()
                .filter(v -> v.hasAnnotation(annotationType.asSubclass(java.lang.annotation.Annotation.class)))
                .collect(Collectors.toUnmodifiableList());
    }
}
