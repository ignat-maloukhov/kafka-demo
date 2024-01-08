package demo.ignat.producer.application.service;

public interface SendMessageService<T> {

    void send(T message);

}
