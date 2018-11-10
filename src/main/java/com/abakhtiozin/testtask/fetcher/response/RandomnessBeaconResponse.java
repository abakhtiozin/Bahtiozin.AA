package com.abakhtiozin.testtask.fetcher.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RandomnessBeaconResponse {

    private final String rawResponseBody;

    public RandomnessBeaconResponse(final String rawResponseBody) {
        this.rawResponseBody = rawResponseBody;
    }

    public String retrieveOutputValue() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(rawResponseBody);
        final JsonNode pulseNode = jsonNode.get("pulse");
        return pulseNode.get("outputValue").asText();
    }
}
