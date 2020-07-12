package com.validator.demo.validator;

import com.validator.demo.annotation.CategoryValid;
import com.validator.demo.annotation.VersionValid;
import com.validator.demo.constant.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<CategoryValid,Object> {
    /**
     * FlagValidator注解规定的那些有效值
     */
    //private String values;

    @Override
    public void initialize(CategoryValid categoryValidator) {
        //this.values = versionValidator.values();
        //this.values = "1.0,2.0,3.0";
    }

    /**
     * 用户输入的值，必须是FlagValidator注解规定的那些值其中之一。
     * 否则，校验不通过。
     * @param value 用户输入的值，如从前端传入的某个值
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 切割获取值
        //String[] value_array = Constants.APP_VERSION_LIST.split(",");
        //Boolean isFlag = false;
        /*
        for (int i = 0; i < value_array.length; i++){
            // 存在一致就跳出循环
            if (value_array[i] .equals(value)){
                isFlag = true; break;
            }
        }
        */
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