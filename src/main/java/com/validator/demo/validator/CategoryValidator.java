package com.validator.demo.validator;

import com.validator.demo.annotation.CategoryValid;
import com.validator.demo.annotation.VersionValid;
import com.validator.demo.constant.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<CategoryValid,Object> {
    //通过value传递的有效值
    //private String values;

    @Override
    public void initialize(CategoryValid categoryValidator) {
        //this.values = versionValidator.values();
    }

    /**
     * 校验是否通过
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String strValue = value.toString();
        if (strValue.length() != 4) {
            return false;
        }
        //判断是否全部由英文组成
        boolean isEN=strValue.matches("[a-zA-Z]+");
        if (!isEN) {
            return false;
        }
        return true;
    }
}