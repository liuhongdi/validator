package com.validator.demo.validator;

import com.validator.demo.annotation.VersionValid;
import com.validator.demo.constant.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VersionValidator implements ConstraintValidator<VersionValid,Object> {

    //预定义传递的值
    //private String values;
    @Override
    public void initialize(VersionValid versionValidator) {
        //this.values = versionValidator.values();
    }

    //version是否符合定义
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 切割获取值
        String[] value_array = Constants.APP_VERSION_LIST.split(",");
        Boolean isFlag = false;
        for (int i = 0; i < value_array.length; i++){
            // 存在一致就跳出循环
            if (value_array[i] .equals(value)){
                isFlag = true; break;
            }
        }
        return isFlag;
    }
}
