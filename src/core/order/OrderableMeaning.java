package core.order;

import core.view.TypeMeaningView;

import java.util.Optional;

public final class OrderableMeaning {

    private final TypeMeaningView view;
    private final Optional<Integer> order;

    public OrderableMeaning(TypeMeaningView view, Optional<Integer> order) {
        this.view = view;
        this.order = order;
    }

    public TypeMeaningView view() {
        return view;
    }

    public Optional<Integer> order() {
        return order;
    }
}
