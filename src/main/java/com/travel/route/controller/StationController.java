package com.travel.route.controller;


import com.travel.route.dto.StationRequest;
import com.travel.route.model.Station;
import com.travel.route.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations/")
public class StationController {

    @Autowired
    StationService service;


    @PutMapping("/{station_id}")
    public ResponseEntity<Station> createStation(@PathVariable Long station_id, @RequestBody StationRequest body) {
        return ResponseEntity.ok(service.createStation(body, station_id));
    }


}
