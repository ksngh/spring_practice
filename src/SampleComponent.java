public class SampleComponent {

    private boolean initialized = false;

    void step1_initialize() {
        System.out.println("step1: initialize");
        initialized = true;
    }

    void step2_execute() {
        if (!initialized) {
            throw new IllegalStateException("not initialized");
        }
        System.out.println("step2: execute");
    }

    void step3_cleanup() {
        System.out.println("step3: cleanup");
    }
}
