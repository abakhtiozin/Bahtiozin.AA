package com.abakhtiozin.testtask.fetcher.rest;

import com.abakhtiozin.testtask.fetcher.response.RandomnessBeaconResponse;

import java.util.Collections;

public class RandomnessBeaconRestController {

    private final HttpProvider httpProvider;

    public RandomnessBeaconRestController(final HttpProvider httpProvider) {
        this.httpProvider = httpProvider;
    }

    public RandomnessBeaconResponse fetch(final String url) {
        final Request request = new Request(url, HttpMethod.GET, Collections.emptyMap());
        final Response rawResponse = httpProvider.send(request);
        return new RandomnessBeaconResponse(rawResponse.getBody());
    }
}
