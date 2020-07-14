package com.validator.demo.controller;

import com.validator.demo.annotation.CategoryValid;
import com.validator.demo.annotation.VersionValid;
import com.validator.demo.constant.ResponseCode;
import com.validator.demo.exception.BusinessException;
import com.validator.demo.util.ResultUtil;
import com.validator.demo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
//@RestController
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/age")
    @ResponseBody
    public ResultUtil age(@Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100") @RequestParam("age") Integer age) {
        return ResultUtil.success("this is age");
    }


    @GetMapping("/home")
    @ResponseBody
    public ResultUtil home(@VersionValid(message = "v取值错误")@RequestParam("v") String version) {
        return ResultUtil.success("this is home");
    }


    @GetMapping("/category")
    @ResponseBody
    public ResultUtil category(@Pattern(regexp="^[a-zA-Z]{4}$", message="分类取值错误")@RequestParam("cate") String category) {
        return ResultUtil.success("this is in category");
    }


    @GetMapping("/user")
    //@ResponseBody
    public String user() {
        return "user/user";
    }

    @PostMapping("/usersaveed")
    @ResponseBody
    //public ResultUtil usersaveed(@Validated UserVo userVo) {
    public ResultUtil usersaveed(@Validated UserVo userVo) {
        System.out.println("----------email:"+userVo.getEmail());
        return ResultUtil.success("this is in usersaveed");
    }

}
