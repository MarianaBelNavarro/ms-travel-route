package com.travel.route.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for StationRequest.
 * Represents a request to create a new station.
 *
 * @author mariana.navarro
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "DTO for StationRequest. Represents a request to create a new station.")
@Getter
@Setter
public class StationRequest {

    @Schema(description = "The name of the station.", example = "Central Station")
    private String name;
}
