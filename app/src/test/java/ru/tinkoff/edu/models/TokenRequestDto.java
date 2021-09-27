package ru.tinkoff.edu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.HashMap;
import java.util.Map;


public class TokenRequestDto {


    /**
     * Client login for auth
     * (Required)
     */
    @JsonProperty("password")
    @JsonPropertyDescription("Client password for auth")
    private String password;

    @JsonProperty("rememberMe")
    @JsonPropertyDescription("Remember flag")
    private Boolean rememberMe;


    @JsonProperty("username")
    @JsonPropertyDescription("Client username for auth")
    private String username;
    /**
     * Client salt
     * (Required)
     */

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
    @JsonProperty("password")
    public TokenRequestDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @JsonProperty("rememberMe")
    public TokenRequestDto setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }


    @JsonProperty("created")
    public TokenRequestDto setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Client salt
     * (Required)
     */
    @JsonProperty("rememberMe")
    public Boolean getRememberMe() {
        return rememberMe;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }


}
