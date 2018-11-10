package com.abakhtiozin.testtask.fetcher.rest;

import java.util.List;
import java.util.Map;

class Response {
    private final int statusCode;
    private final Map<String, List<String>> headers;
    private final String body;

    Response(final int statusCode, final Map<String, List<String>> headers, final String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    int getStatusCode() {
        return statusCode;
    }

    Map<String, List<String>> getHeaders() {
        return headers;
    }

    String getBody() {
        return body;
    }
}
