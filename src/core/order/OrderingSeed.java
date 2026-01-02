package core.order;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderingSeed {

    private final List<OrderableMeaning> meanings;

    public OrderingSeed(List<OrderableMeaning> meanings) {
        this.meanings = List.copyOf(meanings);
    }

    public List<OrderableMeaning> all() {
        return meanings;
    }

    public List<OrderableMeaning> withOrderHint() {
        return meanings.stream()
                .filter(m -> m.order().isPresent())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<OrderableMeaning> withoutOrderHint() {
        return meanings.stream()
                .filter(m -> m.order().isEmpty())
                .collect(Collectors.toUnmodifiableList());
    }
}
