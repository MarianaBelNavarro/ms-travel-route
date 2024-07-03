package com.travel.route.util;

import com.travel.route.model.Path;

import java.util.*;


/**
 * Utility class for creation and information of path and station.
 */
public class Graph {
    private final Map<Long, List<Path>> nearnessStationList = new HashMap<>();


    /**
     * Utility class for selecting the best route in a travel route system.
     */
    public void createStation(Long stationId) {
        nearnessStationList.putIfAbsent(stationId, new ArrayList<>());
    }

    /**
     * Creates a new path between two stations with the given cost.
     *
     * @param pathId        the ID of the path
     * @param sourceId      the ID of the source station
     * @param destinationId the ID of the destination station
     * @param cost          the cost of the path
     */
    public void createPath(Long pathId,Long sourceId, Long destinationId, double cost) {
        nearnessStationList.get(sourceId).add(new Path(pathId, sourceId, destinationId, cost));
        nearnessStationList.get(destinationId).add(new Path(pathId, destinationId, sourceId, cost));
    }

    /**
     * Retrieves the list of paths originating from the specified station.
     *
     * @param stationId the ID of the station
     * @return a list of paths originating from the specified station
     */
    public List<Path> getPathsFromStation(Long stationId) {
        return nearnessStationList.get(stationId);
    }

    /**
     * Retrieves the set of all stations in the graph.
     *
     * @return a set of all station IDs in the graph
     */
    public Set<Long> getStations() {
        return nearnessStationList.keySet();
    }
}
