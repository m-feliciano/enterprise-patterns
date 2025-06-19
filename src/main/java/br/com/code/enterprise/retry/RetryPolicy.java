package br.com.code.enterprise.retry;

public interface RetryPolicy {
    boolean shouldRetry(Exception exception, int attempt);

    long getWaitTime(int attempt);

    int getMaxAttempts();
}
