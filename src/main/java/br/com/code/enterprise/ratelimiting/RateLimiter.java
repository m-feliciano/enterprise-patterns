package br.com.code.enterprise.ratelimiting;

public interface RateLimiter {
    boolean tryAcquire(String key);

    int getRemainingTokens(String key);

    int getLimit(String key);

    void resetLimit(String key);
}
