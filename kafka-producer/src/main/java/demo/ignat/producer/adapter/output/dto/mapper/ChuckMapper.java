package demo.ignat.producer.adapter.output.dto.mapper;

import demo.ignat.producer.adapter.output.dto.ChuckMessage;
import demo.ignat.producer.application.model.ChuckFact;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ChuckMapper {
    ChuckMessage map(ChuckFact model);
}
