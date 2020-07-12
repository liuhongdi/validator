package com.validator.demo.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidatorConfig {

    /*
    *@author:liuhongdi
    *@date:2020/7/12 上午10:48
    *@description:遇到第一个错误后立即返回，而不是遍历完全部错误
     * @param
    *@return:
    */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true") //快速验证模式，有第一个参数不满足条件直接返回
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    //配置2
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

}