package core.order;

import java.util.Optional;

public final class OrderMetadataReader {

    public Optional<Integer> read(Class<?> type) {
        OrderHint hint = type.getAnnotation(OrderHint.class);
        return hint == null
                ? Optional.empty()
                : Optional.of(hint.value());
    }
}
