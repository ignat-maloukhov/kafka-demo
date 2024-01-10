package demo.ignat.producer.application.port;

import demo.ignat.producer.application.core.model.ChuckFact;

public interface ChuckInstancePortOut extends InstancePortOut<ChuckFact> {
    /**
     * Send Chuck fact to output port
     *
     * @param model
     */
    @Override
    public void send(ChuckFact model);
}
