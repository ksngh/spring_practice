public class SampleService {

    private final String name;

    public SampleService() {
        this.name = "default";
    }

    public SampleService(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println("execute: " + name);
    }

    private void internal() {
        System.out.println("internal logic");
    }
}
