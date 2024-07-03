package com.travel.route.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Model for ShortestPath.
 * Represents the shortest path between origin and destination.
 *
 * @author mariana.navarro
 */

@Getter
@Setter
@Schema(description = "Model for ShortestPath. Represents the shortest path between origin and destination.")
public class ShortestPath {

    @Schema(description = "shortest path")
    private List<Long> path;

    @Schema(description = "cost of the shortest path")
    private double cost;

    public ShortestPath(List<Long> path, double cost) {
        this.path = path;
        this.cost = cost;
    }
}
