import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class OrderSensitiveExecution {

    public static void main(String[] args) throws Exception {
        SampleComponent component = new SampleComponent();

        // 프레임워크 입장에서 보면:
        // "이 객체가 가진 메서드들 중,
        //  실행해야 할 것들을 찾아서 실행하면 되겠지?"
        Method[] methods = SampleComponent.class.getDeclaredMethods();

        List<Method> executable = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("step")) {
                executable.add(method);
            }
        }

        // 순서 규칙 없음
        for (Method method : executable) {
            method.setAccessible(true);
            method.invoke(component);
        }
    }
}
