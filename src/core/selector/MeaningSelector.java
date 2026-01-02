package core.selector;

import core.registry.MeaningRegistry;
import core.view.TypeMeaningView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class MeaningSelector {

    private final MeaningRegistry registry;

    public MeaningSelector(MeaningRegistry registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    public List<TypeMeaningView> select(Predicate<TypeMeaningView> filter) {
        List<TypeMeaningView> result = new ArrayList<>();
        for (TypeMeaningView view : registry.all()) {
            if (filter.test(view)) {
                result.add(view);
            }
        }
        return result;
    }
}
