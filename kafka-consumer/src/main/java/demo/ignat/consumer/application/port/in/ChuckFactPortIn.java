package demo.ignat.consumer.application.port.in;


import demo.ignat.consumer.application.core.model.ChuckFact;

public interface ChuckFactPortIn extends InstancePortIn<ChuckFact> {

    /*
     * Use case for model
     */
    @Override
    ChuckFact pull();
}
