package com.validator.demo.annotation;

import com.validator.demo.validator.VersionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//验证版本号是否符合系统定义
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = VersionValidator.class)
public @interface VersionValid {
    //用value传递的值
    //String values();
    //version无效时的提示内容
    String message() default "version必须属于预定义的值";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}