package demo.ignat.producer.adapter.output.message.mapper;

import demo.ignat.producer.adapter.output.message.ChuckMessage;
import demo.ignat.producer.application.core.model.ChuckFact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/*
 * This is dto
 */
@Mapper(componentModel = "spring")
public interface ChuckMapper {

    @Mapping(target = "message", source = "model.fact")
    ChuckMessage map(ChuckFact model);
}
