package core.registry;

import core.view.ReflectionTypeMeaningView;
import core.view.TypeMeaningView;

import java.util.Objects;

public final class MeaningRegistrar {

    private final MeaningRegistry registry;

    public MeaningRegistrar(MeaningRegistry registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    public void register(Class<?> type) {
        TypeMeaningView view = new ReflectionTypeMeaningView(type);
        registry.register(view);
    }
}
