import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Step0Reflection {

    public static void main(String[] args) {
        Object value = getAnnotationAttribute(
                UserService.class,
                Role.class,
                "value"
        );

        System.out.println(value); // 기대값: "ADMIN"
    }

    /**
     * STEP 0 최종 요구사항:
     * - target(Class)에 annotationType이 직접 있으면 사용
     * - 없으면 meta-annotation을 재귀적으로 탐색
     * - attributeName에 해당하는 값을 reflection으로 반환
     * - 못 찾으면 null
     */
    static Object getAnnotationAttribute(
            Class<?> target,
            Class<? extends Annotation> annotationType,
            String attributeName
    ) {
        // 순환 탐색 방지용
        Set<Class<? extends Annotation>> visited = new HashSet<>();

        // 1. 직접 붙은 어노테이션 먼저 확인
        Annotation direct = target.getAnnotation(annotationType);
        if (direct != null) {
            return readAttribute(direct, attributeName);
        }

        // 2. meta-annotation 재귀 탐색
        for (Annotation ann : target.getAnnotations()) {
            Object value = findInMetaAnnotation(
                    ann.annotationType(),
                    annotationType,
                    attributeName,
                    visited
            );
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    /**
     * meta-annotation 재귀 탐색
     */
    static Object findInMetaAnnotation(
            Class<? extends Annotation> current,
            Class<? extends Annotation> targetType,
            String attributeName,
            Set<Class<? extends Annotation>> visited
    ) {
        // 무한 루프 방지
        if (!visited.add(current)) {
            return null;
        }

        // meta-annotation 직접 발견
        Annotation found = current.getAnnotation(targetType);
        if (found != null) {
            return readAttribute(found, attributeName);
        }

        // 더 위로 올라가며 재귀 탐색
        for (Annotation meta : current.getAnnotations()) {
            Object value = findInMetaAnnotation(
                    meta.annotationType(),
                    targetType,
                    attributeName,
                    visited
            );
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    /**
     * 어노테이션 attribute를 reflection으로 읽는다
     */
    static Object readAttribute(
            Annotation annotation,
            String attributeName
    ) {
        try {
            Method method = annotation.annotationType().getMethod(attributeName);
            return method.invoke(annotation);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read attribute '" + attributeName +
                            "' from annotation " + annotation.annotationType(),
                    e
            );
        }
    }
}

