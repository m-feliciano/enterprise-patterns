package br.com.code.enterprise.retry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Retryable {
    Class<? extends Throwable>[] retryFor() default {Exception.class};

    Class<? extends Throwable>[] noRetryFor() default {};

    int maxAttempts() default 3;

    String backoffStrategy() default "fixed";

    long initialInterval() default 1000L;

    double multiplier() default 2.0;

    long maxInterval() default 30000L;
}
