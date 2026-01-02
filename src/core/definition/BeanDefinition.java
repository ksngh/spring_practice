package core.definition;

import java.util.Objects;

public final class BeanDefinition {

    private final String beanName;
    private final Class<?> beanType;

    public BeanDefinition(String beanName, Class<?> beanType) {
        this.beanName = Objects.requireNonNull(beanName);
        this.beanType = Objects.requireNonNull(beanType);
    }

    public String beanName() {
        return beanName;
    }

    public Class<?> beanType() {
        return beanType;
    }
}
