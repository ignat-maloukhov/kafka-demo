package demo.ignat.producer.adapter.output.dto.mapper;

import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import demo.ignat.producer.application.model.ChuckMessage;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ChuckMapper {
    ChuckMessageDto map(ChuckMessage model);
}
