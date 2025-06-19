package br.com.code.enterprise.retry;

import java.util.concurrent.Callable;

public interface RetryTemplate {
    <T> T execute(Callable<T> task) throws Exception;

    <T> T execute(Callable<T> task, RetryPolicy retryPolicy) throws Exception;
}
