package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/11/7
 */
@Documented //元注解
@Constraint(validatedBy = {StateValidation.class}) // 指定提供校验规则
@Target({FIELD}) // 元注解
@Retention(RUNTIME) // 元注解
public @interface State {

    String message() default "{jakarta.validation.constraints.State.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}