package br.com.code.enterprise.ratelimiting;

public interface RateLimitAlgorithm {
    boolean tryConsume(String key, int tokens);

    int getRemainingTokens(String key);

    void refill(String key);
}
