package core.registry;

import core.view.TypeMeaningView;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class MeaningRegistry {

    private final Map<Class<?>, TypeMeaningView> registry = new LinkedHashMap<>();

    public void register(TypeMeaningView view) {
        Objects.requireNonNull(view);
        registry.put(view.getClass(), view);
    }

    public Collection<TypeMeaningView> views() {
        return Collections.unmodifiableCollection(registry.values());
    }

    public boolean contains(Class<?> type) {
        return registry.containsKey(type);
    }

    public int size() {
        return registry.size();
    }
}
