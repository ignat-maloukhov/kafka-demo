package demo.ignat.admin.application.message;

import com.fasterxml.jackson.annotation.JsonProperty;

record ChuckMessage(@JsonProperty("message") String message,
                    @JsonProperty("id") int id) {
}