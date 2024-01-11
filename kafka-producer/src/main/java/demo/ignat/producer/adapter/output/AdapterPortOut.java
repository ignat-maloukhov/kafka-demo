package demo.ignat.producer.adapter.output;

import demo.ignat.producer.adapter.output.message.ChuckMessage;
import demo.ignat.producer.adapter.output.message.mapper.ChuckMapper;
import demo.ignat.producer.application.core.model.ChuckFact;
import demo.ignat.producer.application.port.out.ChuckFactPortOut;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdapterPortOut implements ChuckFactPortOut<ChuckFact> {

    private final AbstractAdapterOut<ChuckMessage> adapterOut;
    private final ChuckMapper mapper;

    @Override
    public void push(ChuckFact model) {
        adapterOut.sent(mapper.map(model));
    }
}
