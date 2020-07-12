package com.validator.demo.interceptor;

import com.validator.demo.constant.Constants;
import com.validator.demo.constant.ResponseCode;
import com.validator.demo.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
*
* interceptor for api sign
*
* */
@Component
public class ValidatorInterceptor implements HandlerInterceptor {

    /*
    *@author:liuhongdi
    *@date:2020/7/1 下午4:00
    *@description:检查通用的变量是否存在，是否合法
     * @param request：请求对象
     * @param response：响应对象
     * @param handler：处理对象：controller中的信息   *
     * *@return:true表示正常,false表示被拦截
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查appid是否存在？
        String appId = request.getParameter("appid");
        if (appId == null) {
            throw new BusinessException(ResponseCode.ARG_NO_APPID);
        }
        //appid是否符合定义
        if (!Constants.APP_ID_LIST.contains(appId)) {
            throw new BusinessException(ResponseCode.ARG_APPID_VALID);
        }
        //version参数是否存在
        String version = request.getParameter("version");
        if (version == null) {
            throw new BusinessException(ResponseCode.ARG_NO_VERSION);
        }
        //当appid是ios时，version是否符合定义
        if (appId.equals("IOS")) {
            if (!Constants.IOS_VERSION_LIST.contains(version)) {
                throw new BusinessException(ResponseCode.ARG_VERSION_VALID);
            }
        }
        //uuid参数是否存在
        String uuid = request.getParameter("uuid");
        if (uuid == null) {
            throw new BusinessException(ResponseCode.ARG_NO_UUID);
        }
        //sign校验无问题,放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}