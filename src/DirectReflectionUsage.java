import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DirectReflectionUsage {

    public static void main(String[] args) {
        try {
            // 1. 생성
            Class<?> clazz = SampleService.class;

            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);

            Object service = constructor.newInstance("core");

            // 2. 메서드 호출
            Method execute = clazz.getDeclaredMethod("execute");
            execute.setAccessible(true);

            execute.invoke(service);

        } catch (InvocationTargetException e) {
            // 👈 반드시 unwrap 필요
            Throwable target = e.getTargetException();
            throw new RuntimeException("user code exception", target);

        } catch (Exception e) {
            // 👈 나머지 reflection 예외
            throw new RuntimeException("reflection failed", e);
        }
    }
}
