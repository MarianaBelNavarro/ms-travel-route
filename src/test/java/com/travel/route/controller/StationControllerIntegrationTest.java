package com.travel.route.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateStation() throws Exception {
        Long stationId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.put("/stations/{station_id}", stationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Station A\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
