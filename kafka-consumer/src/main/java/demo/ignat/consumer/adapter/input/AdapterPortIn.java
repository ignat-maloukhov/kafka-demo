package demo.ignat.consumer.adapter.input;

import demo.ignat.consumer.adapter.input.kafka.KafkaInputListener;
import demo.ignat.consumer.adapter.input.message.ChuckMessage;
import demo.ignat.consumer.adapter.input.message.mapper.ChuckMapper;
import demo.ignat.consumer.application.core.model.ChuckFact;
import demo.ignat.consumer.application.port.in.ChuckFactPortIn;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdapterPortIn implements ChuckFactPortIn {

    private final AbstractAdapterIn<ChuckMessage> adapterIn;
    
    @Override
    public ChuckFact pull() {
        return null;
    }
    
}
