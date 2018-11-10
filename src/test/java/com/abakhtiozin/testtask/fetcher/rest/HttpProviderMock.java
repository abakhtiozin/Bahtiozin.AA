package com.abakhtiozin.testtask.fetcher.rest;

import java.util.Collections;

public class HttpProviderMock implements HttpProvider {
    @Override
    public Response send(final Request request) {
        return new Response(
                400,
                Collections.emptyMap(),
                "{\"pulse\":{\"outputValue\" : \"mock\"}}"
        );
    }
}
