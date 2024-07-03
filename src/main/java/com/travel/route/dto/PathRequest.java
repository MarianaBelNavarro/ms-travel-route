package com.travel.route.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for PathRequest.
 * Represents a request to create or retrieve a path.
 *
 * @author mariana.navarro
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "DTO for PathRequest. Represents a request to create or retrieve a path.")
public class PathRequest {

    @JsonProperty(value = "path_id")
    @Schema(description = "ID of the path", example = "1")
    private Long id;

    @JsonProperty(value = "source_id")
    @Schema(description = "ID of the source station", example = "101")
    private Long sourceId;

    @JsonProperty(value = "destination_id")
    @Schema(description = "ID of the destination station", example = "102")
    private Long destinationId;

    @Schema(description = "Cost of the path", example = "5.5")
    private double cost;
}
