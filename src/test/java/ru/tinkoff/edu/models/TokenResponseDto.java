package ru.tinkoff.edu.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;


/**
 * Client
 * <p>
 * Entity with personalized information about client
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "login",
        "salt",
        "secret"
})
//@Generated("jsonschema2pojo")
public class TokenResponseDto {


    /**
     * Client login for auth
     * (Required)
     */
    @JsonProperty("id_token")
    @JsonPropertyDescription("Client id_token")
    private String id_token;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Client login for auth
     * (Required)
     */

    /**
     * Client login for auth
     * (Required)
     */
    @JsonProperty("id_token")
    public TokenResponseDto setIdToken(String id_token) {
        this.id_token = id_token;
        return this;
    }

    /**
     * Client salt
     * (Required)
     */
    @JsonProperty("id_token")
    public String getIdToken() {
        return id_token;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
