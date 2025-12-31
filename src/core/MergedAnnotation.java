package core;

import java.lang.annotation.Annotation;
import java.util.Optional;

/**
 * STEP 1 핵심 인터페이스
 *
 * "어노테이션을 어떻게 찾았는지"는 숨기고,
 * "의미상 어노테이션이 존재하는지"와
 * "속성(attribute)을 어떻게 읽는지"만 노출한다.
 */
public interface MergedAnnotation<A extends Annotation> {

    /**
     * 이 View가 나타내는 어노테이션 타입
     * 예: Role.class, Transactional.class
     */
    Class<A> getType();

    /**
     * 의미상 어노테이션이 존재하는가?
     *
     * - 직접 붙어 있어도 true
     * - meta-annotation으로 발견돼도 true
     * - 없으면 false
     */
    boolean isPresent();

    /**
     * attribute 값을 타입 안정성 없이 가져온다.
     *
     * - 존재하지 않으면 예외를 던질지
     * - null을 반환할지는
     * 구현체의 정책
     */
    Object getValue(String attributeName);

    /**
     * attribute 값을 타입 안정성 있게 가져온다.
     */
    <T> T getValue(String attributeName, Class<T> requiredType);

    /**
     * attribute 원본 접근 (디버깅/확장용)
     */
    Optional<Object> getRawValue(String attributeName);
}
