package core.order;

import core.view.TypeMeaningView;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderingSeedFactory {

    private final OrderMetadataReader reader = new OrderMetadataReader();

    public OrderingSeed create(List<TypeMeaningView> views) {
        List<OrderableMeaning> meanings =
                views.stream()
                        .map(v -> {
                            try {
                                return new OrderableMeaning(
                                        v,
                                        reader.read(Class.forName(v.typeName()))
                                );
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.toList());

        return new OrderingSeed(meanings);
    }
}
