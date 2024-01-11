package demo.ignat.consumer.application.port.in;

public interface InstancePortIn<T> {

    /*
     * Use case for model
     */
    T pull();

}
