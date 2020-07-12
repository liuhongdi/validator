package com.validator.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/error/400");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/error/401");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/error/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/error/500");
        registry.addErrorPages(error400Page,error401Page,error404Page,error500Page);
    }
}