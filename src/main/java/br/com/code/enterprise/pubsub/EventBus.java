package br.com.code.enterprise.pubsub;

public interface EventBus {
    void subscribe(String topic, Subscriber subscriber);

    void unsubscribe(String topic, Subscriber subscriber);
}

