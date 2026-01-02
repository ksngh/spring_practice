package core.definition;

import core.view.TypeMeaningView;

public final class MeaningToBeanDefinitionConverter {

    public BeanDefinition convert(TypeMeaningView meaning) {
        String name = defaultBeanName(meaning.type());
        return new BeanDefinition(name, meaning.type());
    }

    private String defaultBeanName(Class<?> type) {
        String simple = type.getSimpleName();
        return Character.toLowerCase(simple.charAt(0)) + simple.substring(1);
    }
}
