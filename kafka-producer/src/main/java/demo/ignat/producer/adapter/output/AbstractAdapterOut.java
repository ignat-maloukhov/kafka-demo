package demo.ignat.producer.adapter.output;

public interface AbstractAdapterOut<T> {
    void sent(T message);

}
