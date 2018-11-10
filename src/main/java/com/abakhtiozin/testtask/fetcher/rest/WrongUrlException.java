package com.abakhtiozin.testtask.fetcher.rest;

class WrongUrlException extends RuntimeException {

    WrongUrlException(final String url, final String regex) {
        super("url " + url + " does not match " + regex);
    }
}
