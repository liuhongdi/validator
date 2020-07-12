package com.validator.demo.vo;

import com.validator.demo.annotation.PassValid;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@PassValid(password = "password", password_confirm = "confirmPassword")
public class UserVo {

    @Size(min = 2,max = 10,message = "name:姓名长度必须为1到10")
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //@Range(min=10, max=100,message = "年龄需位于10到100之间")
    @Min(value = 10,message = "age:年龄最小为10")
    @Max(value = 100,message = "age:年龄最大为100")
    private int age;
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @NotNull(message = "mobile:手机号码不能为空")
    @Size(min = 11, max = 11, message = "mobile:手机号码必须为11位")
    @Pattern(regexp="^[1]\\d{10}$", message="mobile:手机号码格式错误")
    private String mobile;
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @NotBlank(message = "email:邮箱不能为空")
    @Email(message = "email:邮箱格式错误")
    private String email;
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "password:密码不能为空")
    String password;
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "confirmPassword:确认密码不能为空")
    String confirmPassword;
    public String getConfirmPassword() {
        return this.confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    //@Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")

}
