package com.travel.route.controller;


import com.travel.route.dto.StationRequest;
import com.travel.route.model.Station;
import com.travel.route.service.StationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations/")
@Tag(name = "Station Management System", description = "Operations pertaining to stations in Station Management System")
public class StationController {

    @Autowired
    StationService service;

    @Operation(summary = "Create a new station")
    @PutMapping("/{station_id}")
    public ResponseEntity<Station> createStation(
            @Parameter(description = "Id of the station to be created") @PathVariable Long station_id,
            @Parameter(description = "Details of the new station") @RequestBody StationRequest body) {
        return ResponseEntity.ok(service.createStation(body, station_id));
    }


}
