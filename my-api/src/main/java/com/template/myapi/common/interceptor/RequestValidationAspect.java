package com.template.myapi.common.interceptor;

import com.template.myapi.controller.req.BaseRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Component
public class RequestValidationAspect {

    @Before("bean(*Controller) && " +
            "(execution(* *(.., com.template.myapi.controller.req.BaseRequest+, ..)) || " +
            "execution(* *(.., java.util.Collection<com.template.myapi.controller.req.BaseRequest+>+, ..)))")
    public void before(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseRequest) {
                ((BaseRequest) arg).validate();
            } else if (arg instanceof Collection) {
                Collection dtos = (Collection) arg;
                dtos.forEach(dto -> {
                    if (dto instanceof BaseRequest) {
                        ((BaseRequest) dto).validate();
                    }
                });
            }
        }
    }
}
