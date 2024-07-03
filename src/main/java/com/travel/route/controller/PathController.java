package com.travel.route.controller;

import com.travel.route.dto.PathRequest;
import com.travel.route.model.Path;
import com.travel.route.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paths/")
public class PathController {
    @Autowired
    PathService service;


    @PutMapping("/{path_id}")
    public ResponseEntity<Path> createPath(@PathVariable Long path_id, @RequestBody PathRequest body) {
        return ResponseEntity.ok(service.createPath(body, path_id));
    }

    @GetMapping("/{source_id}/{destination_id}")
    public ResponseEntity<Path> findShortestPath(@PathVariable Long source_id, @PathVariable Long destination_id, @RequestBody PathRequest body) {
        return ResponseEntity.ok(service.findShortestPath(source_id, destination_id, body));
    }

}
