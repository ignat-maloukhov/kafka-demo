package demo.ignat.consumer.adapter.input.message.mapper;

import demo.ignat.consumer.adapter.input.message.ChuckMessage;
import demo.ignat.consumer.application.core.model.ChuckFact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/*
 * This is dto
 */
@Mapper(componentModel = "spring")
public interface ChuckMapper {

    @Mapping(target = "fact", source = "message.message")
    ChuckFact map(ChuckMessage message);
}
