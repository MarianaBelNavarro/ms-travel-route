package com.travel.route.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for Station.
 * Represents a station with a name.
 *
 * @author mariana.navarro
 */

@Getter
@Setter
@Schema(description = "Model for Station. Represents a station with a name.")
public class Station {

    @Schema(description = "id of the station.", example = "Central Station")
    private Long id;

    @Schema(description = "Name of the station.", example = "Central Station")
    private String name;
}
