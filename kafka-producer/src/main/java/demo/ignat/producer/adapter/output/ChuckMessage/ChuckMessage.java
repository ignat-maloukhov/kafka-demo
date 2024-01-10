package demo.ignat.producer.adapter.output.ChuckMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChuckMessage(@JsonProperty("message") String message) {


}
