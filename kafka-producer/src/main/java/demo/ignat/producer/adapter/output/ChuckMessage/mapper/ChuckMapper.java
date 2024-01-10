package demo.ignat.producer.adapter.output.ChuckMessage.mapper;

import demo.ignat.producer.adapter.output.ChuckMessage.ChuckMessage;
import demo.ignat.producer.application.core.model.ChuckFact;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ChuckMapper {
    ChuckMessage map(ChuckFact model);
}
