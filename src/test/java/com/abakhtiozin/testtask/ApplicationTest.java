package com.abakhtiozin.testtask;

import com.abakhtiozin.testtask.domain.ResponseValueDecomposer;
import com.abakhtiozin.testtask.domain.Result;
import com.abakhtiozin.testtask.fetcher.response.RandomnessBeaconResponse;
import com.abakhtiozin.testtask.fetcher.rest.HttpProviderMock;
import com.abakhtiozin.testtask.fetcher.rest.RandomnessBeaconRestController;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ApplicationTest {

    @Test
    public void applicationTest() throws IOException {
        final String url = "https://test.com";
        final RandomnessBeaconRestController restController = new RandomnessBeaconRestController(new HttpProviderMock());
        final RandomnessBeaconResponse randomnessBeaconResponse = restController.fetch(url);
        final String outputValue = randomnessBeaconResponse.retrieveOutputValue();
        System.out.println("outputValue:" + outputValue);
        final ResponseValueDecomposer decomposer = new ResponseValueDecomposer(outputValue);
        final Result result = decomposer.decompose();
        Assert.assertEquals(4, result.countOfUniqueCharacters());
        Assert.assertEquals("Wrong count of occurrence 'm' character ", 1, result.getCountOfCharOccurrence('m'));
        Assert.assertEquals("Wrong count of occurrence 'o' character ", 1, result.getCountOfCharOccurrence('o'));
        Assert.assertEquals("Wrong count of occurrence 'c' character ", 1, result.getCountOfCharOccurrence('c'));
        Assert.assertEquals("Wrong count of occurrence 'k' character ", 1, result.getCountOfCharOccurrence('k'));
    }
}
