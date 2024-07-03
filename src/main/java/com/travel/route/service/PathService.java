package com.travel.route.service;

import com.travel.route.dto.PathRequest;
import com.travel.route.model.Path;
import com.travel.route.model.ShortestPath;
import com.travel.route.util.BestRouteSelector;
import com.travel.route.util.Graph;
import org.springframework.stereotype.Service;

/**
 * Service for managing paths.
 * Provides methods to create paths and find short paths between stations.
 *
 * @author mariana.navarro
 */

@Service
public class PathService {

    private final Graph graph = new Graph();
    private final BestRouteSelector bestRouteSelector = new BestRouteSelector(graph);

    /**
     * Creates a new path between stations.
     *
     * @param body       The details of the path to be created.
     * @param path_id The ID of the path to be created.
     * @return The created Path object.
     */
    public Path createPath(PathRequest body,Long path_id) {
        Path path = new Path(path_id, body.getSourceId(), body.getDestinationId(), body.getCost());

        graph.createStation(path.getSourceId());
        graph.createStation(path.getDestinationId());
        graph.createPath(path_id,path.getSourceId(), path.getDestinationId(), path.getCost());
        return path;
    }

    /**
     * Finds the shortest path between two stations.
     *
     * @param source_id      The ID of the source station.
     * @param destination_id The ID of the destination station.
     * @return The response object representing the shortest path.
     */
    public ShortestPath findShortestPath(Long source_id, Long destination_id) throws Exception {
        if(graph.getStations().isEmpty()){
            throw new Exception("No stations loaded.");
        }

        return bestRouteSelector.findShortestPath(source_id, destination_id);
    }
}
