package demo.ignat.producer.application.port;

public interface InstancePortOut<T> {

    void send(T model);

}
