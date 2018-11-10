package com.abakhtiozin.testtask.fetcher.response;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RandomnessBeaconResponseTest {

    @Test(expected = NullPointerException.class)
    public void emptyResponse() throws IOException {
        final RandomnessBeaconResponse response = new RandomnessBeaconResponse("{}");
        response.retrieveOutputValue();
    }

    @Test(expected = IOException.class)
    public void wrongResponse() throws IOException {
        final RandomnessBeaconResponse response = new RandomnessBeaconResponse("{\"pulse\":\"outputValue\" : \"A311\"}}");
        response.retrieveOutputValue();
    }

    @Test
    public void validResponse() throws IOException {
        final RandomnessBeaconResponse response = new RandomnessBeaconResponse("{\"pulse\":{\"outputValue\" : \"A3\"}}");
        final String outputValue = response.retrieveOutputValue();
        Assert.assertEquals("Output value is not as expected", "A3", outputValue);
    }
}