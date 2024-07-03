package com.travel.route.service;

import com.travel.route.dto.StationRequest;
import com.travel.route.model.Station;
import com.travel.route.util.Graph;
import org.springframework.stereotype.Service;

/**
 * Service for managing stations.
 * Provides methods to create stations.
 *
 * @author mariana.navarro
 */
@Service
public class StationService {

    private final Graph graph = new Graph();


    /**
     * Creates a new station.
     *
     * @param body       The details of the station to be created.
     * @param station_id The ID of the station to be created.
     * @return The created Station object.
     */
    public Station createStation(StationRequest body, Long station_id) {

        Station station = new Station();
        station.setId(station_id);
        station.setName(body.getName());

        graph.createStation(station_id);
        return station;
    }

}
