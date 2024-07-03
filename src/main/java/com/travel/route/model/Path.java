package com.travel.route.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Path {
    private Long id;

    private Long sourceId;

    private Long destinationId;

    private double cost;
}
