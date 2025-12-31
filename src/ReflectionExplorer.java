import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionExplorer {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = SampleService.class;

        // 1. 클래스 기본 정보
        System.out.println("class name = " + clazz.getName());
        System.out.println("super class = " + clazz.getSuperclass().getName());

        // 2. 생성자 정보
        System.out.println("\nconstructors:");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println(" - " + constructor);
        }

        // 3. 메서드 정보
        System.out.println("\nmethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method);
        }
    }
}
