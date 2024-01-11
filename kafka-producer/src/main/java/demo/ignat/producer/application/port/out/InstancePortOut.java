package demo.ignat.producer.application.port.out;

public interface InstancePortOut<T> {

    /*
     * Use case for model
     */
    void push(T dto);

}
