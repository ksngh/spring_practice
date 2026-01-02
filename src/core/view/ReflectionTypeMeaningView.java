package core.view;

import java.util.Objects;

public final class ReflectionTypeMeaningView implements TypeMeaningView {

    private final Class<?> type;

    public ReflectionTypeMeaningView(Class<?> type) {
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public Class<?> type() {
        return type;
    }
}
