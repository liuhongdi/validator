package com.validator.demo.annotation;

import com.validator.demo.validator.CategoryValidator;
import com.validator.demo.validator.VersionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//验证分类id是否有效
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = CategoryValidator.class)
public @interface CategoryValid {
    //categoryid无效时的提示内容
    String message() default "分类id错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}