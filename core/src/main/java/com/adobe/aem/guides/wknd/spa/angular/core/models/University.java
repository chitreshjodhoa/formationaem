package com.adobe.aem.guides.wknd.spa.angular.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class University {
    private String[] domains;

    @JsonProperty("state-province")
    private String stateProvince;

    private String country;

    @JsonProperty("alpha_two_code")
    private String alphaTwoCode;

    @JsonProperty("web_pages")
    private String[] webPages;

    private String name;
}
