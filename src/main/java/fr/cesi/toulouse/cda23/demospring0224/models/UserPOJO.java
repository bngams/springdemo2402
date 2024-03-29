package fr.cesi.toulouse.cda23.demospring0224.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPOJO {
    @JsonProperty("username")
    private String name;
}
