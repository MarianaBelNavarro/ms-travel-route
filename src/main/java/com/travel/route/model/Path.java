package com.travel.route.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for Path.
 * Represents a path between two stations with an associated cost.
 *
 * @author mariana.navarro
 */

@Getter
@Setter
@Schema(description = "Model for Path. Represents a path between two stations with an associated cost.")
public class Path {

    @Schema(description = "id of the path.", example = "1")
    private Long id;

    @Schema(description = "id of the source station.", example = "101")
    private Long sourceId;

    @Schema(description = "id of the destination station.", example = "102")
    private Long destinationId;

    @Schema(description = "The cost associated with the path.", example = "50.5")
    private double cost;
}
