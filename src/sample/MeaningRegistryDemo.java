package sample;

import core.registry.MeaningRegistrar;
import core.registry.MeaningRegistry;

public class MeaningRegistryDemo {

    public static void main(String[] args) {
        MeaningRegistry registry = new MeaningRegistry();
        MeaningRegistrar registrar = new MeaningRegistrar(registry);

        registrar.register(UserRepository.class);
        registrar.register(UserService.class);
        registrar.register(UserController.class);

        System.out.println(registry.size());
    }
}
