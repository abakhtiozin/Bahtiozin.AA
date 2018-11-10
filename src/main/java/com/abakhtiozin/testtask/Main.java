package com.abakhtiozin.testtask;

import com.abakhtiozin.testtask.domain.ResponseValueDecomposer;
import com.abakhtiozin.testtask.domain.Result;
import com.abakhtiozin.testtask.fetcher.response.RandomnessBeaconResponse;
import com.abakhtiozin.testtask.fetcher.rest.JavaNetHttpProvider;
import com.abakhtiozin.testtask.fetcher.rest.RandomnessBeaconRestController;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        System.out.println("Start");
        final String url = "https://beacon.nist.gov/beacon/2.0/pulse/last";
        final RandomnessBeaconRestController restController = new RandomnessBeaconRestController(new JavaNetHttpProvider());
        final RandomnessBeaconResponse randomnessBeaconResponse = restController.fetch(url);
        final String outputValue = randomnessBeaconResponse.retrieveOutputValue();
        System.out.println("outputValue:" + outputValue);
        final ResponseValueDecomposer decomposer = new ResponseValueDecomposer(outputValue);
        final Result result = decomposer.decompose();
        result.print();
        System.out.println("End");
    }

}
