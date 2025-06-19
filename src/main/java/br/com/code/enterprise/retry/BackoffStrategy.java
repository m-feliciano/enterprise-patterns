package br.com.code.enterprise.retry;

public interface BackoffStrategy {
    long calculateWaitTime(int attempt);
}
