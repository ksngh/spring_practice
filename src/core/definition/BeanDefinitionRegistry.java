package core.definition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BeanDefinitionRegistry {

    private final List<BeanDefinition> definitions = new ArrayList<>();

    public void register(BeanDefinition definition) {
        definitions.add(definition);
    }

    public List<BeanDefinition> all() {
        return Collections.unmodifiableList(definitions);
    }
}
