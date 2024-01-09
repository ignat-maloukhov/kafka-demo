package demo.ignat.producer.adapter.output.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChuckMessage(@JsonProperty("message") String message) {


}
