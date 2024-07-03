package com.travel.route.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathRequest {

    @JsonProperty(value = "path_id")
    private Long id;

    @JsonProperty(value = "source_id")
    private Long sourceId;

    @JsonProperty(value = "destination_id")
    private Long destinationId;

    private double cost;
}
