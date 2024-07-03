package com.travel.route.util;

import com.travel.route.model.Path;
import com.travel.route.model.ShortestPath;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

/**
 * Utility class for selecting the best route in a travel route system.
 */
public final class BestRouteSelector {

    @Value(value = "${travel.route.initial.cost}")
    private double initialCost;

    private final Graph graph;

    public BestRouteSelector(Graph graph) {
        this.graph = graph;
    }

    /**
     * Finds the shortest path from the source station to the destination station.
     *
     * @param sourceId      the ID of the source station
     * @param destinationId the ID of the destination station
     * @return a list of station IDs representing the shortest path from the source
     *         station to the destination station, or an empty list if no path is found
     */
    public ShortestPath findShortestPath(Long sourceId, Long destinationId) {
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        PriorityQueue<Path> queue = new PriorityQueue<>(Comparator.comparingDouble(Path::getCost));

        for (Long station : graph.getStations()) {
            distances.put(station, Double.MAX_VALUE);
            previous.put(station, null);
        }
        distances.put(sourceId, 0.0);

        queue.add(new Path(null, sourceId, destinationId, 0.0));

        while (!queue.isEmpty()) {
            Path currentPath = queue.poll();
            Long currentStation = currentPath.getSourceId();

            if (currentStation.equals(destinationId)) {
                break;
            }

            for (Path path : graph.getPathsFromStation(currentStation)) {
                Long neighbor = path.getDestinationId();
                double newDist = distances.get(currentStation) + path.getCost();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentStation);
                    queue.add(new Path(null, currentStation, neighbor, newDist));
                }
            }
        }

        List<Long> path = reconstructPath(previous, sourceId, destinationId);
        double cost = distances.getOrDefault(destinationId, Double.MAX_VALUE);
        return  new ShortestPath(path, cost);
    }

    /**
     * Reconstructs the shortest path from the source station to the destination station
     * based on the provided map of previous stations.
     *
     * @param previous      a map of previous stations for each station in the path
     * @param sourceId      the ID of the source station
     * @param destinationId the ID of the destination station
     * @return a list of station IDs representing the shortest path from the source
     *         station to the destination station
     */
    private List<Long> reconstructPath(Map<Long, Long> previous, Long sourceId, Long destinationId) {
        List<Long> path = new ArrayList<>();
        for (Long at = destinationId; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        if (path.isEmpty() || !path.get(0).equals(sourceId)) {
            return new ArrayList<>();
        }
        return path;
    }

    /**
     * Calculates the total cost of a given path.
     *
     * @param path a list of station IDs representing the path
     * @return the total cost of the path
     */
    public double calculatePath(List<Long> path) {
        double cost = initialCost;

        for (int i = 0; i < path.size() - 1; i++) {
            cost = cost * path.get(i);
        }
        return cost;
    }


}
