package com.validator.demo.validator;

import com.validator.demo.annotation.PassValid;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//validator,判断两个密码是否一致
public class PassValidator implements ConstraintValidator<PassValid, Object> {

     //密码
     private String passFieldName;
     //确认密码
     private String confirmFieldName;

     @Override
     public void initialize(final PassValid constraintAnnotation) {
         passFieldName = constraintAnnotation.password();
         confirmFieldName = constraintAnnotation.password_confirm();
     }

     @Override
     public boolean isValid(final Object src, final ConstraintValidatorContext context) {
         BeanWrapperImpl wrapper = new BeanWrapperImpl(src);
        Object passObj = wrapper.getPropertyValue(passFieldName);
         Object confirmObj = wrapper.getPropertyValue(confirmFieldName);
         return passObj != null && passObj.equals(confirmObj);
     }
 }