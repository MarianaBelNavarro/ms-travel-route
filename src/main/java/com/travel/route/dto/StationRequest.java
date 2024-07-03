package com.travel.route.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for StationRequest.
 * Represents a request to create a new station.
 *
 * @author mariana.navarro
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "DTO for StationRequest. Represents a request to create a new station.")
public class StationRequest {

    @Schema(description = "The name of the station.", example = "Central Station")
    private String name;
}
