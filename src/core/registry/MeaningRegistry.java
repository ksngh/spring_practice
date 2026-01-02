package core.registry;

import core.view.TypeMeaningView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MeaningRegistry {

    private final List<TypeMeaningView> meanings = new ArrayList<>();

    public void register(TypeMeaningView view) {
        meanings.add(view);
    }

    public List<TypeMeaningView> all() {
        return Collections.unmodifiableList(meanings);
    }
}
