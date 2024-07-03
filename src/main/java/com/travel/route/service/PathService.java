package com.travel.route.service;

import com.travel.route.dto.PathRequest;
import com.travel.route.model.Path;
import org.springframework.stereotype.Service;

/**
 * Service for managing paths.
 * Provides methods to create paths and find short paths between stations.
 *
 * @author mariana.navarro
 */

@Service
public class PathService {

    /**
     * Creates a new path between stations.
     *
     * @param body       The details of the path to be created.
     * @param station_id The ID of the path to be created.
     * @return The created Path object.
     */
    public Path createPath(PathRequest body, Long station_id) {
        return null;
    }

    /**
     * Finds the shortest path between two stations.
     *
     * @param source_id      The ID of the source station.
     * @param destination_id The ID of the destination station.
     * @param body           Additional details for finding the shortest path.
     * @return The Path object representing the shortest path.
     */
    public Path findShortestPath(Long source_id, Long destination_id, PathRequest body) {
        return null;
    }
}
