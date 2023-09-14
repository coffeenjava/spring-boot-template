package com.template.myapi.config;

import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Collection;

@Configuration
public class RequestValidationConfig {

    @Bean
    public LocalValidatorFactoryBean customValidatorFactoryBean(MessageSource messageSource) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new CustomRequestValidator();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory(messageSource);
        localValidatorFactoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        return localValidatorFactoryBean;
    }

    private static class CustomRequestValidator extends LocalValidatorFactoryBean {
        @Override
        public void validate(final Object target, final Errors errors) {
            if (target instanceof Collection) {
                final Collection c = (Collection) target;

                for (Object e : c) {
                    this.validate(e, errors);
                }
            } else {
                super.validate(target, errors);
            }
        }
    }
}
