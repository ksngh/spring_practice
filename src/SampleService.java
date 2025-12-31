public class SampleService {

    private final String name;

    private SampleService(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.name = name;
    }

    public void execute() {
        System.out.println("execute: " + name);
    }
}
