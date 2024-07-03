package com.travel.route.controller;

import com.travel.route.dto.PathRequest;
import com.travel.route.model.Path;
import com.travel.route.service.PathService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paths/")
@Tag(name = "Path Management System", description = "Operations pertaining to path in Path Management System")
public class PathController {
    @Autowired
    PathService service;


    @Operation(summary = "Create a new path")
    @PutMapping("/{path_id}")
    public ResponseEntity<Path> createPath(
            @Parameter(description = "Id of the path to be created") @PathVariable Long path_id,
            @Parameter(description = "Details of the new path") @RequestBody PathRequest body) {
        return ResponseEntity.ok(service.createPath(body, path_id));
    }

    @Operation(summary = "Get the shortest path between two stations")
    @GetMapping("/{source_id}/{destination_id}")
    public ResponseEntity<Path> findShortestPath(
            @Parameter(description = "Id of the source station") @PathVariable Long source_id,
            @Parameter(description = "Id of the destination station") @PathVariable Long destination_id,
            @Parameter(description = "Details of the path request") @RequestBody PathRequest body) {
        return ResponseEntity.ok(service.findShortestPath(source_id, destination_id, body));
    }

}
