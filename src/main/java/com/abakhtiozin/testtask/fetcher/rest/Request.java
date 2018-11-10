package com.abakhtiozin.testtask.fetcher.rest;

import java.util.Map;

class Request {
    private final String url;
    private final HttpMethod httpMethod;
    private final Map<String, String> headers;

    Request(final String url, final HttpMethod httpMethod, final Map<String, String> headers) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.headers = headers;
    }

    String getUrl() {
        return url;
    }

    String getHttpMethod() {
        return httpMethod.toString();
    }

    Map<String, String> getHeaders() {
        return headers;
    }
}
