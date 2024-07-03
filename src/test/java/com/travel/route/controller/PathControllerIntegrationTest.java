package com.travel.route.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.route.dto.PathRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class PathControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePath() throws Exception {
        Long pathId = 1L;
        Long sourceId = 1L;
        Long destinationId = 2L;
        double cost = 5.0;

        PathRequest pathRequest = new PathRequest(sourceId, destinationId, cost);

        String pathJson = objectMapper.writeValueAsString(pathRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/paths/{path_id}", pathId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pathJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.sourceId").value(sourceId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.destinationId").value(destinationId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost").value(cost));
    }

    @Test
    public void testFindShortestPath() throws Exception {
        Long sourceId = 1L;
        Long destinationId = 3L;

        mockMvc.perform(MockMvcRequestBuilders.get("/paths/{source_id}/{destination_id}", sourceId, destinationId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost").isNumber());
    }
}
