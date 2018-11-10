package com.abakhtiozin.testtask.fetcher.rest;

import com.abakhtiozin.testtask.fetcher.response.RandomnessBeaconResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RandomnessBeaconRestControllerTest {

    @Test(expected = WrongUrlException.class)
    public void wrongUrl() {
        final RandomnessBeaconRestController restController = new RandomnessBeaconRestController(new JavaNetHttpProvider());
        restController.fetch("sd342342");
    }

    @Test
    public void mockProvider() throws IOException {
        final HttpProvider httpProviderMock = request -> {
            final Response mock = new Response(400, null, "{\"pulse\":{\"outputValue\" : \"mock\"}}");
            return mock;
        };
        final RandomnessBeaconRestController restController = new RandomnessBeaconRestController(httpProviderMock);
        final RandomnessBeaconResponse response = restController.fetch("http//:www.google.com");
        final String outputValue = response.retrieveOutputValue();
        Assert.assertEquals("mock", outputValue);
    }
}