package demo.ignat.producer.application.port.out;

import demo.ignat.producer.application.core.model.ChuckFact;

public interface ChuckFactPortOut<C> extends InstancePortOut<ChuckFact> {

    /*
     * Use case for model
     */
    @Override
    void push(ChuckFact model);

}
