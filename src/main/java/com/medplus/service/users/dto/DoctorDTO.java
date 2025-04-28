package com.medplus.service.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// DTO: Mapping from JSON to Class

@Data
public class DoctorDTO {

    @JsonProperty("dcID")
    private String dcID;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailID")
    private String emailID;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("orgID")
    private String orgId;
}
