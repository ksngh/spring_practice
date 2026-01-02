package sample;

import core.registry.MeaningRegistrar;
import core.registry.MeaningRegistry;
import core.selector.MeaningSelector;

public class MeaningSelectorDemo {

    public static void main(String[] args) {
        MeaningRegistry registry = new MeaningRegistry();
        MeaningRegistrar registrar = new MeaningRegistrar(registry);

        registrar.register(UserRepository.class);
        registrar.register(UserService.class);
        registrar.register(UserController.class);

        MeaningSelector selector = new MeaningSelector(registry);

        System.out.println(selector.selectByStereotype("service").size());
        System.out.println(selector.selectByTag("user").size());
    }
}
