package com.validator.demo.annotation;

import com.validator.demo.validator.CategoryValidator;
import com.validator.demo.validator.PassValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//用来验证类中多个字段的validator的注解
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PassValidator.class)
@Documented
public @interface PassValid {
         //报错信息
        String message() default "confirmPassword:两次输入密码需一致";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
          //密码字段
          String password();
          //确认密码字段
          String password_confirm();
}
